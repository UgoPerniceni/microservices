package fr.esgi.kafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.kafka.domain.KafkaTransaction;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.AuthorizationException;
import org.apache.kafka.common.errors.OutOfOrderSequenceException;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class KafkaTransactionService implements IKafkaTransaction {
    @Override
    public Optional<RecordMetadata> produce(KafkaTransaction kafkaTransaction) {
        Optional<RecordMetadata> _parserMetaData = null;

        Properties appProps = new Properties();
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String appConfigPath = rootPath + "app.properties";
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return _parserMetaData;
        }

        KafkaProducer<String, KafkaTransaction> kafkaProducer = new KafkaProducer<String, KafkaTransaction>(appProps);

        ProducerRecord<String, KafkaTransaction> producerRecord = new ProducerRecord<String, KafkaTransaction>(
                (String) appProps.get("topic.name"), "key", kafkaTransaction);

        Future<RecordMetadata> futureResult = kafkaProducer.send(producerRecord);
        try {
            _parserMetaData = Optional.ofNullable(futureResult.get(5000, TimeUnit.MILLISECONDS));
        } catch (ProducerFencedException | OutOfOrderSequenceException | AuthorizationException | InterruptedException | ExecutionException | TimeoutException e) {
            // We can't recover from these exceptions, so our only option is to close the producer and exit.
            System.out.println("1 " + e.getMessage());
        } catch (KafkaException e) {
            System.out.println("2 " + e.getMessage());
            // For all other exceptions, just abort the transaction and try again.
            kafkaProducer.abortTransaction();
        } finally {
            kafkaProducer.close();
        }
        return _parserMetaData;
    }

    @Override
    public Optional<List<KafkaTransaction>> consume() {
        Optional<List<KafkaTransaction>> _kafkaTransactions = null;

        Properties appProps = new Properties();
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            String appConfigPath = rootPath + "app.properties";
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return _kafkaTransactions;
        }

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(appProps);
        ConsumerRecords<String, String> consumerRecords =
                consumer.poll(Duration.ofMillis(3000));
        List<KafkaTransaction> kafkaTransactions = new ArrayList<>();
        for (ConsumerRecord<String, String> record : consumerRecords) {
            try {
                kafkaTransactions.add(new ObjectMapper().readValue(record.value(), KafkaTransaction.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return _kafkaTransactions;
            }
        }
        _kafkaTransactions = Optional.of(kafkaTransactions);
        return _kafkaTransactions;
    }
}

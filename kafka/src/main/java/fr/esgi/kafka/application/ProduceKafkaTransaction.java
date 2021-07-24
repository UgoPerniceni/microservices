package fr.esgi.kafka.application;

import fr.esgi.kafka.domain.KafkaTransaction;
import fr.esgi.kafka.service.IKafkaTransaction;
import fr.esgi.kafka.service.KafkaTransactionService;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduceKafkaTransaction {

    private KafkaTransactionService kafkaTransactionService;

    public ProduceKafkaTransaction(KafkaTransactionService kafkaTransactionService) {
        this.kafkaTransactionService = kafkaTransactionService;
    }
    public Optional<RecordMetadata> execute(KafkaTransaction kafkaTransaction) {
        return kafkaTransactionService.produce(kafkaTransaction);
    }
}

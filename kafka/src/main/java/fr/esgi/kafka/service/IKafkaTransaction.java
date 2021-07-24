package fr.esgi.kafka.service;

import fr.esgi.kafka.domain.KafkaTransaction;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.List;
import java.util.Optional;

public interface IKafkaTransaction {
    Optional<RecordMetadata> produce(KafkaTransaction kafkaTransaction);
    Optional<List<KafkaTransaction>> consume();
}

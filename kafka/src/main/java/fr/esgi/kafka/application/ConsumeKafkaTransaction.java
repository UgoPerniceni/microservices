package fr.esgi.kafka.application;

import fr.esgi.kafka.domain.KafkaTransaction;
import fr.esgi.kafka.service.IKafkaTransaction;
import fr.esgi.kafka.service.KafkaTransactionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumeKafkaTransaction {

    private KafkaTransactionService kafkaTransactionService;

    public ConsumeKafkaTransaction(KafkaTransactionService kafkaTransactionService) {
        this.kafkaTransactionService = kafkaTransactionService;
    }
    public Optional<List<KafkaTransaction>> execute() {
        return kafkaTransactionService.consume();
    }

}

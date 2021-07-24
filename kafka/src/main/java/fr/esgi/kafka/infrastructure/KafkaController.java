package fr.esgi.kafka.infrastructure;

import fr.esgi.kafka.application.ConsumeKafkaTransaction;
import fr.esgi.kafka.application.ProduceKafkaTransaction;
import fr.esgi.kafka.domain.KafkaTransaction;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final ConsumeKafkaTransaction consumeKafkaTransaction;
    private final ProduceKafkaTransaction produceKafkaTransaction;

    public KafkaController(ConsumeKafkaTransaction consumeKafkaTransaction, ProduceKafkaTransaction produceKafkaTransaction) {
        this.consumeKafkaTransaction = consumeKafkaTransaction;
        this.produceKafkaTransaction = produceKafkaTransaction;
    }

    @PostMapping("/produce")
    public ResponseEntity<RecordMetadata> produce(@RequestBody final KafkaTransaction kafkaTransaction) {
        if(kafkaTransaction == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "KafkaTransaction is not complete.");
        }
        try {
            Optional<RecordMetadata> _recordMetaData = produceKafkaTransaction.execute(kafkaTransaction);
            if (_recordMetaData.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fail to produce KafkaTransaction to Kafka topic.");
            }
            return new ResponseEntity<>(_recordMetaData.get(), HttpStatus.OK);
        } catch (Exception exception){
            exception.printStackTrace();
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/consume")
    public ResponseEntity<List<KafkaTransaction>> consume() {
        try {
            Optional<List<KafkaTransaction>> _kafkaTransactions = consumeKafkaTransaction.execute();
            if (_kafkaTransactions.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fail to consume at Kafka topic.");
            }
            return new ResponseEntity<>(_kafkaTransactions.get(), HttpStatus.OK);
        } catch (Exception exception){
            exception.printStackTrace();
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }


}

package fr.esgi.kafka.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KafkaTransaction {
    public KafkaTransaction(Object obj) {
        this.obj = obj;
    }

    private Object obj;
}
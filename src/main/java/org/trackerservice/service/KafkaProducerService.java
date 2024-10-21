package org.trackerservice.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.trackerservice.dto.TaxiCoordinate;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "driver_coordinates";

    private final KafkaTemplate<String, TaxiCoordinate> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, TaxiCoordinate> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCoordinates(TaxiCoordinate coordinate) {
        kafkaTemplate.send(TOPIC, coordinate.getDriverId(), coordinate);
    }
}
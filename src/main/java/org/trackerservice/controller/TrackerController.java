package org.trackerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.trackerservice.dto.TaxiCoordinate;
import org.trackerservice.service.KafkaProducerService;

@RestController
public class TrackerController {

    private final KafkaProducerService kafkaProducerService;

    public TrackerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/tracker/coords")
    public ResponseEntity<String> receiveCoordinates(@RequestBody TaxiCoordinate coordinate) {
        kafkaProducerService.sendCoordinates(coordinate);
        return ResponseEntity.ok("Coordinates sent to Kafka");
    }
}
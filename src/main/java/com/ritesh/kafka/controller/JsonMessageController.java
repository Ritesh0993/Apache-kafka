package com.ritesh.kafka.controller;

import com.ritesh.kafka.model.User;
import com.ritesh.kafka.producer.JsonkafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonkafkaProducer jsonkafkaProducer;

    public JsonMessageController(JsonkafkaProducer jsonkafkaProducer) {
        this.jsonkafkaProducer = jsonkafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonkafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message send to kafka topic");
    }


}

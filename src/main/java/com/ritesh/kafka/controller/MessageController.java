package com.ritesh.kafka.controller;

import com.ritesh.kafka.producer.kafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

 private kafkaProducer  kafkaProducer;

 public MessageController(kafkaProducer kafkaProducer){
    this.kafkaProducer = kafkaProducer;
 }

 @GetMapping("/publish")
 //http:localhost:8080/api/v1/kafka/publish?message=hello World
 public ResponseEntity<String> publish(@RequestParam("message") String message){

     kafkaProducer.sendMessage(message);
     return ResponseEntity.ok("Message send to the topic");
 }




}

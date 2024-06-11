package com.ritesh.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(kafkaProducer.class);

    private KafkaTemplate <String,String> kafkaTemplate;

    public kafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message send %s",message));
        kafkaTemplate.send(topicName,message);
    }



}

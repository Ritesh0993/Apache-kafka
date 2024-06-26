package com.ritesh.kafka.producer;

import com.ritesh.kafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonkafkaProducer {

    @Value("${spring.kafka.topic-json.name}")
    private String jsonTopicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonkafkaProducer.class);

    private KafkaTemplate<String, User>  kafkaTemplate;

    public JsonkafkaProducer (KafkaTemplate<String,User> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(User data){
        Message<User> message = MessageBuilder
                .withPayload(data)
                        .setHeader(KafkaHeaders.TOPIC,jsonTopicName)
                                .build();
        kafkaTemplate.send(message);
        LOGGER.info(String.format("user details send sucessfully - > %s",data.toString()));
    }



}

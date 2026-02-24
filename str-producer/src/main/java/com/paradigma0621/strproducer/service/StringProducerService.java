package com.paradigma0621.strproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Send message {}", message);
        kafkaTemplate.send("str-topic", message); // "str-topic" is the name of the topic to which the message will be sent
    }

    public void sendMessageAnotherTopic(String message) {
        log.info("Send message {}", message);
     //   kafkaTemplate.send("str-another-topic", message); // "str-another-topic" is the name of the topic to which
                                                            // the message will be sent
                                                   // It can be as simple as the method above, or you can add details
                                                    // as shown below.
        kafkaTemplate.send("str-another-topic", message).addCallback(
                success -> {
                    if(success != null) {
                        log.info("Send message with success {}", message);
                        log.info("Partition {}, Offset {}",
                                success.getRecordMetadata().partition(),
                                success.getRecordMetadata().offset());
                    }
                },
                error -> log.error("Error send message")
        );
    }
}

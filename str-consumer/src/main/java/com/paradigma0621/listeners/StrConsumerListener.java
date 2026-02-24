package com.paradigma0621.listeners;

import com.paradigma0621.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows // Equivalent to: public void createWithException(String message) throws Exception {
    @StrConsumerCustomListener(groupId = "group-1") // Also provides the errorHandler() attribute
                                                    // defined in StrConsumerCustomListener.java
    public void createWithException(String message) {
        log.info("CREATE ::: Receive message {}", message);
        throw new IllegalArgumentException("EXCEPTION..."); // Without Kafka error handling, multiple error messages
                                                            // would be logged.
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log2(String message) {
        log.info("LOG ::: Receive message {}", message);
    }

    @StrConsumerCustomListener(groupId = "group-2")
    public void history2(String message) {
        log.info("HISTORY ::: Receive message {}", message);
    }

    // The code above uses custom annotations defined in StrConsumerCustomListener.java.

    // The message undergoes business logic processing before reaching this listener
    @StrConsumerCustomListener(groupId = "group-3", topics = "str-topic",
            containerFactory = "validMessageContainerFactory")
    public void historyWithPreviousAnalysis(String message) {
        log.info("WITH SOME ANALYSIS BEFORE THIS MESSAGE ::: Receive message {}", message);
    }

    // Unlike the code at the beginning of this class, the code below does not use custom annotations.
    @KafkaListener(groupId = "group-a1", topicPartitions = {
            @TopicPartition(topic = "str-another-topic", partitions = {"0"}) },
            containerFactory = "strContainerFactory")
    public void create(String message) {
        log.info("CREATE ANOTHER ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-a1", topicPartitions = {
                    @TopicPartition(topic = "str-another-topic", partitions = {"1","2","3"}) },
                    containerFactory = "strContainerFactory")
    public void log(String message) {
        log.info("LOG ANOTHER ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-a2", topics = "str-another-topic", containerFactory = "strContainerFactory")
    public void history(String message) {
        log.info("HISTORY ANOTHER ::: Receive message {}", message);
    }

}
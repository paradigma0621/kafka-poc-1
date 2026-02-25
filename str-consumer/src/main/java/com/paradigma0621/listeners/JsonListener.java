package com.paradigma0621.listeners;

import com.paradigma0621.model.PaymentDto;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload PaymentDto paymentDto) {
        log.info("Received payment {}", paymentDto.toString());
        sleep(2000);
        log.info("Validating fraud...");
        sleep(2000);

        log.info("Purchase approved...");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload PaymentDto paymentDto) {
        sleep(3000);
        log.info("Generating PDF for product with id {}...", paymentDto.getId());
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        sleep(3000);
        log.info("Sending confirmation email...");
    }
}

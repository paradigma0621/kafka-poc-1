package com.paradigma0621.strproducer.service;

import com.paradigma0621.strproducer.model.PaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    public void sendPayment(PaymentDto paymentDto) {
        log.info("Received payment {}", paymentDto);
        Thread.sleep(1000);

        log.info("Sending payment...");
        kafkaTemplate.send("payment-topic", paymentDto);
    }
}

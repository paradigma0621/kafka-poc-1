package com.paradigma0621.strproducer.controller;

import com.paradigma0621.strproducer.model.PaymentDto;
import com.paradigma0621.strproducer.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    ResponseEntity<PaymentDto> payment(@RequestBody PaymentDto payment) {
        service.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

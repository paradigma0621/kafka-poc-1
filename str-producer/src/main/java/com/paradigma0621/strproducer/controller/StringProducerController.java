package com.paradigma0621.strproducer.controller;

import com.paradigma0621.strproducer.service.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerController {

    private final StringProducerService producerService;

    @PostMapping(value = "/main-topic")
    public ResponseEntity<Void> sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/another-topic")
    public ResponseEntity<Void> sendMessageAnotherTopic(@RequestBody String message) {
        producerService.sendMessageAnotherTopic(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}

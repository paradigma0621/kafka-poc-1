package com.paradigma0621.strproducer.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PaymentDto implements Serializable { //OBS: Important to implements Serializable
    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
}

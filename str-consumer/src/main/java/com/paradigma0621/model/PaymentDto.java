package com.paradigma0621.model;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class PaymentDto implements Serializable { //OBS: Important to implements Serializable
    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
}

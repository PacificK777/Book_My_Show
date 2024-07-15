package com.example.book_my_show.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String refNo;
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;


}

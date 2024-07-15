package com.example.book_my_show.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{ //Ticket
    @ManyToMany
    private List<ShowSeat> showSeats;

    @OneToMany
    private List<Payment> payments;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private int amount;
/*
   1            M
booking ----- showseats  => M:M
   M            1


   1            M
booking ----- payments => 1:M
   1            1

   1           1
booking ----- user  => M:1
   M           1

 */

}

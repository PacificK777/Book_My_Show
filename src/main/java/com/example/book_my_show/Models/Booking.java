package com.example.book_my_show.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{ //Ticket
    private List<ShowSeat> showSeats;
    private List<Payment> payments;
    private User user;
    private BookingStatus bookingStatus;
    private int amount;


}

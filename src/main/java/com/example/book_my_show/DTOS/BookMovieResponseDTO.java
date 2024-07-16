package com.example.book_my_show.DTOS;

import com.example.book_my_show.Models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDTO {
    private Booking booking;
    private ResponseStatus responseStatus;
}

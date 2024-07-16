package com.example.book_my_show.Controllers;

import com.example.book_my_show.DTOS.BookMovieRequestDTO;
import com.example.book_my_show.DTOS.BookMovieResponseDTO;
import com.example.book_my_show.DTOS.ResponseStatus;
import com.example.book_my_show.Models.Booking;
import com.example.book_my_show.Services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    private BookMovieResponseDTO bookMovie(BookMovieRequestDTO requestDTO){

        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();
        try{
          Booking booking = bookingService.bookMovie(
                  requestDTO.getUserID(),
                  requestDTO.getSeatID(),
                  requestDTO.getShowSeatIDs()
          );
          responseDTO.setBooking(booking);
          responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
      catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}

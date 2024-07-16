package com.example.book_my_show.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMovieRequestDTO {
    private Long userID;
    private Long seatID;
    private List<Long> showSeatIDs;
}

package com.example.book_my_show.Models;

public enum Feature {
    TWO_D,
    THREE_D,
    IMAX,
    DOLBY_ATMOS,
    //2D - Cannot write directly as 2D,The issue arises because Java enum values must be valid Java
    // identifiers, which means they cannot start with a digit
}

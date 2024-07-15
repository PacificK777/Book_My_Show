package com.example.book_my_show.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel{
    //private List<Theatre> theatres;
    private String name;
}

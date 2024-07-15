package com.example.book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    @ManyToMany
    private List<Actor> actors;

    /*
      1          M
    movie ---- actor => M:M
      M           1
     */
}

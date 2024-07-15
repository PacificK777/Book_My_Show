package com.example.book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;

    @OneToMany
    private List<Screen> screens;

    @ManyToOne
    private City city;
    /*
       1         M
    theatre----screen => 1:M
       1         1

       1         1
    theatre----city => M:1
       M         1
     */
}

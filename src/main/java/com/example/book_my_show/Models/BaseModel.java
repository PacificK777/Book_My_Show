package com.example.book_my_show.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// used to auto-increment ID
    private Long id;
    private Date createdAt;
    private Date modifiedAt;
}

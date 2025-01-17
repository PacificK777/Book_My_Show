package com.example.book_my_show.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // This class with listen all the changes that can happen into DB
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// used to auto-increment ID
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedAt;
}

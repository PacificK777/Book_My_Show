package com.example.book_my_show.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
/*if we remove (name = "shows"), the code will give runtime error because
show is a reserved keyword in mySQl therefore show table cannot be created
 */

public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    /*
     1          1
    show ---- movie => M:1
     M          1

      1          1
     show ---- screen => M:1
      M          1
     */
}

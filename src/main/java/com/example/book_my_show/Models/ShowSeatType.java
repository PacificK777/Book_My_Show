package com.example.book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel{

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;
    private int price;

    /*
         1             1
    showSeatType ---- show => M:1
         M             1

         1             1
    showSeatType ---- seat => M:1
         M             1

         Trick: if we combine two entities(A+B)
                Cardinaltiy will always be M:1
                AB-----A (M:1)
                AB-----B (M:1)
     */
}

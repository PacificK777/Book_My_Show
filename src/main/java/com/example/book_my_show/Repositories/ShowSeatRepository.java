package com.example.book_my_show.Repositories;

import com.example.book_my_show.Models.Show;
import com.example.book_my_show.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    List<ShowSeat> findAllById(List<Long> showSeatIds);
    //Here, optional is not required as List can be empty but not null


    @Override
    ShowSeat save(ShowSeat showSeat);
}

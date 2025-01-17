package com.example.book_my_show.Repositories;

import com.example.book_my_show.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    Optional<Show> findById(Long showid);
    //Optional is used to avoid null values
}

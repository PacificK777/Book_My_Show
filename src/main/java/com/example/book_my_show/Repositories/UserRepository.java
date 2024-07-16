package com.example.book_my_show.Repositories;

import com.example.book_my_show.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long userid);

    Optional<User> findAllByEmail(String email);
}

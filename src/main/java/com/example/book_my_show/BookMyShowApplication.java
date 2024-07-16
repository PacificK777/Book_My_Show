package com.example.book_my_show;

import com.example.book_my_show.Controllers.UserController;
import com.example.book_my_show.DTOS.SignUpRequestDTO;
import com.example.book_my_show.DTOS.SignUpResponseDTO;
import com.example.book_my_show.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // used By JPA to check the latest update in DB

public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO requestDTO = new SignUpRequestDTO();
        requestDTO.setName("Scaler132");
        requestDTO.setEmail("sample@scaler.com");
        requestDTO.setPassword("scaler777");

        SignUpResponseDTO responseDTO = userController.signUp(requestDTO);

    }
}

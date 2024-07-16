package com.example.book_my_show.Controllers;

import com.example.book_my_show.DTOS.ResponseStatus;
import com.example.book_my_show.DTOS.SignUpRequestDTO;
import com.example.book_my_show.DTOS.SignUpResponseDTO;
import com.example.book_my_show.Models.User;
import com.example.book_my_show.Services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO){
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try{
            User user = userService.signUp(requestDTO.getName(),
                        requestDTO.getEmail(),
                        requestDTO.getPassword());
            responseDTO.setUser(user);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}

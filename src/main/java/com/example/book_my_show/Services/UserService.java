package com.example.book_my_show.Services;

import com.example.book_my_show.Exceptions.UserNotFoundException;
import com.example.book_my_show.Models.User;
import com.example.book_my_show.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository =userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name,
                       String email,
                       String password) throws UserNotFoundException {

        Optional<User> userOptional = userRepository.findAllByEmail(email);
        User savedUser = null;

        if(userOptional.isPresent()){
            //Move to login workflow
        } else{
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            //Save user to DB
            savedUser = userRepository.save(user);
        }
        return savedUser;
    }
}

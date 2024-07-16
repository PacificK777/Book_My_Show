package com.example.book_my_show.Services;

import com.example.book_my_show.Exceptions.ShowNotFoundException;
import com.example.book_my_show.Exceptions.UserNotFoundException;
import com.example.book_my_show.Models.*;
import com.example.book_my_show.Repositories.ShowRepository;
import com.example.book_my_show.Repositories.ShowSeatRepository;
import com.example.book_my_show.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculatorService priceCalculatorService){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userID,
                              Long showID,
                              List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException {
        /*
        1. Get the user with the user id
        2. Get the show with the show id
        3. Get the list of show seats with the showSeat ids
        4. Check if all the seats are available or not
        5. If yes, proceed with the booking
        6. If no, throw an exception
        ----------TAKE A LOCK------------
        7. Check again, if all the seats are available or not
        8. Change the seat status with BLOCKED
        ----------RELEASE THE LOCK----------
        9. Create the booking and move to the payment page
         */
        Optional<User> optionalUser = userRepository.findById(userID);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with ID "+ userID +" not found");
        }
            User user = optionalUser.get();


        Optional<Show> optionalShow = showRepository.findById(showID);
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("Show with ID "+ showID +" not found");
        }
        Show show = optionalShow.get();


        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("Show Seat with id: " + showSeat.getId() + " is not available");
            }
        }

        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            //Save this change into the DB
            showSeatRepository.save(showSeat);
        }
        //Create the booking and move to the payment page
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setCreatedAt(new Date());
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats,show));

        //Save booking object into the DB and return the saved booking object

        return booking;
    }
}

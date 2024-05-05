package com.kirankhanal.user.service.controller;

import com.kirankhanal.user.service.entities.User;
import com.kirankhanal.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
     User newUser = userService.saveUser(user);
     return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }
    private static int retryCount =1;
    @GetMapping("/{userId}")
    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @Retry(name="ratingHotelService", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        logger.info("Retry Count: {}",retryCount);
        retryCount++;
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    public ResponseEntity<User> ratingHotelFallback(Long userId, Exception e){
        logger.info("Fallback method is executed:: ",e.getMessage());
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .userId(0L)
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}

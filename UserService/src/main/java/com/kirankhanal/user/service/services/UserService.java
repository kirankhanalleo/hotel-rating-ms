package com.kirankhanal.user.service.services;

import com.kirankhanal.user.service.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(Long userId);
}

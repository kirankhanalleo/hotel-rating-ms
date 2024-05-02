package com.kirankhanal.user.service.repositories;

import com.kirankhanal.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

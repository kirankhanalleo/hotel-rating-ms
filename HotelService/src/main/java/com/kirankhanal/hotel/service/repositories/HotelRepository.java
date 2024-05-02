package com.kirankhanal.hotel.service.repositories;

import com.kirankhanal.hotel.service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}

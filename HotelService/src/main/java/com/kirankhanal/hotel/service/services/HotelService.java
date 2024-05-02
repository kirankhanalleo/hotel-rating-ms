package com.kirankhanal.hotel.service.services;

import com.kirankhanal.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(Long hotelId);
}

package com.kirankhanal.hotel.service.services.impl;

import com.kirankhanal.hotel.service.entities.Hotel;
import com.kirankhanal.hotel.service.exceptions.ResourceNotFoundException;
import com.kirankhanal.hotel.service.repositories.HotelRepository;
import com.kirankhanal.hotel.service.services.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel not found"));
    }
}

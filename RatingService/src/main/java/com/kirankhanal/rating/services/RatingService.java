package com.kirankhanal.rating.services;

import com.kirankhanal.rating.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingsByUserId(Long userId);

    List<Rating> getRatingsByHotelId(Long hotelId);

}

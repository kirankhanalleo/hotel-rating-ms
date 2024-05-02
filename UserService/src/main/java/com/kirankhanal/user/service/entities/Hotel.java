package com.kirankhanal.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelDesc;
}

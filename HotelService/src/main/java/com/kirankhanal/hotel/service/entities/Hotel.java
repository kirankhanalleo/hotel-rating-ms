package com.kirankhanal.hotel.service.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    @Column(name="hotel_name", nullable=false)
    private String hotelName;

    @Column(name="hotel_address", nullable = false)
    private String hotelAddress;

    @Column(name="hotel_desc", nullable = false)
    private String hotelDesc;
}

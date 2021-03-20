package com.bridgelabs;

import com.bridgelabs.HotelReservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class HotelReservationTesting {

    IHotel hotelReservation;
    HotelDetails lakewood = new HotelDetails("Lakewood", 110);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 160);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220);


    @BeforeEach
    public void initial() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
    }

    @Test
    public void givenRegularCustomerName_WeekAndWeekendRate_ableToAddToHotelReservationSystem() {

        System.out.println(HotelReservation.hotels);
        Assertions.assertTrue(HotelReservation.hotels.contains(lakewood));

    }

}

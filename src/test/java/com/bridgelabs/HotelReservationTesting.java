package com.bridgelabs;
import com.bridgelabs.HotelReservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelReservationTesting {

    IHotel hotelReservation;
    HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 160, 60);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150);


    @BeforeEach
    public void initial() {
        hotelReservation = new HotelReservation();
    }

    @Test
    public void givenRegularCustomerName_WeekAndWeekendRate_ableToAddToHotelReservationSystem() {
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);
        System.out.println(HotelReservation.hotels);
        Assertions.assertTrue(HotelReservation.hotels.contains(lakewood));

    }
}

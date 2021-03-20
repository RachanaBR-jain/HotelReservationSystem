package com.bridgelabs;

import com.bridgelabs.HotelReservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class HotelReservationTesting {

    IHotel hotelReservation;
    HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 160, 60);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150);


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

    @Test
    public void givendateRange_WhenHotelProper_ShouldReturnTrue() {
        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 10);
        LocalDate lastDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
        String hName = hotelReservation.findCheapestHotel(startDate, lastDate);
        Assertions.assertEquals("Lakewood", hName);
    }
    @Test
    public void givenRegularCustomerName_WeekAndWeekendRate_ableToAddWeekAndWeenEndRate() {

        System.out.println(HotelReservation.hotels);
        Assertions.assertTrue(HotelReservation.hotels.contains(bridgewood));

    }
}

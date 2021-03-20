package com.bridgelabs;

import com.bridgelabs.HotelReservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class HotelReservationTesting {

    IHotel hotelReservation;
    HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90, 3);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50, 4);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 5);


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
        String hName = hotelReservation.getCheapestHotel(startDate, lastDate);
        Assertions.assertEquals("Lakewood", hName);
    }

    @Test
    public void givenRegularCustomerName_WeekAndWeekendRate_ableToAddWeekAndWeenEndRate() {

        System.out.println(HotelReservation.hotels);
        Assertions.assertTrue(HotelReservation.hotels.contains(bridgewood));

    }

    @Test
    public void givenDateRange_ForBothWeekDayWeeEnd_ShouldReturnTrue() {
        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 10);
        LocalDate lastDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
        String hName = hotelReservation.getCheapestHotelBasedOnWeekDayWeekEnd(startDate, lastDate);
        Assertions.assertEquals("Lakewood and Bridgewood", hName);
    }

    @Test
    public void returnRateOfHotels() {

        int ratingOfLakehood = lakewood.getRating();
        int ratingOfBridgehood = bridgewood.getRating();
        int ratingOfRridgeBood = ridgewood.getRating();
        System.out.println(ratingOfLakehood);
        System.out.println(ratingOfBridgehood);
        System.out.println(ratingOfRridgeBood);
        Assertions.assertEquals(3, ratingOfLakehood);
        Assertions.assertEquals(4, ratingOfBridgehood);
        Assertions.assertEquals(5, ratingOfRridgeBood);
    }
    @Test
    public void givenDateRange_ForBothWeekDayWeeEnd_FindCheckestHostelBasedOnRating_ShouldReturnTrue() {
        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 10);
        LocalDate lastDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
        String hName = hotelReservation.getCheapestHotelBasedOnRating(startDate, lastDate);
        Assertions.assertEquals("Bridgewood", hName);
    }
}

package com.bridgelabs;

import com.bridgelabs.HotelReservationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class HotelReservationTesting {

    IHotel hotelReservation;
    HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90, 80, 80, 3);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50, 110, 50, 4);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 100, 40, 5);


    @BeforeEach
    public void initial() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel_Reward((IRewardCustomer) lakewood);
        hotelReservation.addHotel_Reward((IRewardCustomer) bridgewood);
        hotelReservation.addHotel_Reward((IRewardCustomer) ridgewood);
    }

    @Test
    public void givenWeekDayAndWeekEndRatesOf_Regular_RewardCostomer_mustReturnTrue() {
        System.out.println(HotelReservation.hotelsReward);
        Assertions.assertTrue(HotelReservation.hotelsReward.contains(lakewood));
    }

    @Test
    public void givenDateRange_WhenHotelProper_ShouldReturnTrue() {
        // String input1 ="2020-09-10,2020-09-11"; // YYYY-MM-DD format
        String input = "2020-09-11,2020-09-12";
        String bestRated = hotelReservation.bestRatedHotel();
        System.out.println("Best rated hotel: " + hotelReservation.bestRatedHotel());
        System.out.println("Cheapest best rated hotel for reward customers: " + hotelReservation.getCheapestHotel(input, "Reward"));
        Assertions.assertEquals("Ridgewood", bestRated);
    }
}

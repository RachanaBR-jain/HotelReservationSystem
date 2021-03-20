package com.bridgelabs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HotelReservationTesting {

    IHotel hotelReservation;
    IHotelDetails lakewood = new HotelDetails("Lakewood", 110, 90, 80, 80, 3);
    IHotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50, 110, 50, 4);
    IHotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 100, 40, 5);


    @BeforeEach
    public void initial() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel_Reward((IRewardCostomer) lakewood);
        hotelReservation.addHotel_Reward((IRewardCostomer) bridgewood);
        hotelReservation.addHotel_Reward((IRewardCostomer) ridgewood);
    }

    @Test
    public void givenWeekDayAndWeekEndRatesOf_Regular_RewardCostomer_mustReturnTrue() {
        System.out.println(HotelReservation.hotelsReward);
        Assertions.assertTrue(HotelReservation.hotelsReward.contains(lakewood));
    }
}

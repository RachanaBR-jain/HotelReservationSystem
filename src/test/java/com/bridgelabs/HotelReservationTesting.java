package com.bridgelabs;

import com.bridgelabs.HotelReservation;
import com.bridgelabs.IRegularCostomer;
import com.bridgelabs.IRewardCostomer;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.Month;

public class HotelReservationTesting {

    IHotel hotelReservation;
    IRewardCostomer lakewood = new HotelDetails("Lakewood", 110, 90, 80,80,3);
    IRewardCostomer bridgewood = new HotelDetails("Bridgewood", 150, 50,110,50, 4);
    IRewardCostomer ridgewood = new HotelDetails("Ridgewood", 220, 150, 100,40 ,5);


    @BeforeEach
    public void initial() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel_Reward(lakewood);
        hotelReservation.addHotel_Reward(bridgewood);
        hotelReservation.addHotel_Reward(ridgewood);
    }

    @Test
    public  void givenWeekDayAndWeekEndRatesOf_Regular_RewardCostomer_mustReturnTrue(){
        System.out.println(HotelReservation.hotelsReward);
        Assertions.assertTrue(HotelReservation.hotelsReward.contains(lakewood));
    }

}

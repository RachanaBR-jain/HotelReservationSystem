package com.bridgelabs;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class HotelReservation<minRate> implements IHotel {
    public static List<HotelDetails> hotels;
    static LocalDate stateDate, endDate;


    public HotelReservation() {
        hotels = new ArrayList<>();
    }

    public List<HotelDetails> addHotel(HotelDetails hotel) {
        hotels.add(hotel);
        return hotels;
    }

    public String findCheapestHotel(LocalDate stateDate, LocalDate endDate) {
        long noOfDays = ChronoUnit.DAYS.between(stateDate, endDate);
        System.out.println((int) noOfDays);
        for (HotelDetails hotel : hotels) {
            int total = 0;
            for (int i = 0; i <= noOfDays; i++)
                total += hotel.getRegularCustomerWeekDayRate();
            hotel.setRegularCustomerWeekDayRate(total);
        }
        HotelDetails minRate = Collections.min(hotels);
        System.out.println("Cheapest Hotel: " + minRate);
        return minRate.getHotelName();

    }
}



package com.bridgelabs;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class HotelReservation<minRate> implements IHotel {
    public static final int LAKEHOOD_RATING = 3;
    public static final int BRIDGEHOOD_RATING = 4;
    public static final int RIDGEHOOD_RARING = 5;
    public static List<HotelDetails> hotels;

    public HotelReservation() {
        hotels = new ArrayList<>();
    }

    public List<HotelDetails> addHotel(HotelDetails hotel) {
        hotels.add(hotel);
        return hotels;
    }

    public String getCheapestHotel(LocalDate stateDate, LocalDate endDate) {
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

    public String getCheapestHotelBasedOnWeekDayWeekEnd(LocalDate startDate, LocalDate endDate) {
        long noOfDays = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("No of days between the days are:" + (int) noOfDays);
        Integer total[] = new Integer[3];
        int i = 0;
        for (HotelDetails hotel : hotels) {
            total[i] = (int) noOfDays * (hotel.getRegularCustomerWeekDayRate() + hotel.getRegularCustomerWeekEndRate());
            i++;
        }
        int minCost = Math.min(total[0], Math.min(total[1], total[2]));
        if (minCost == total[0] && minCost == total[1]) {
            System.out.println("Lakewood and Bridgewood with total cost: $" + minCost);
            return "Lakewood and Bridgewood";
        } else if (minCost == total[0] && minCost == total[2]) {
            System.out.println("Lakewood and Ridgewood with total cost: $" + minCost);
            return "Lakewood and Ridgewood";
        } else if (minCost == total[1] && minCost == total[2]) {
            System.out.println("Bridgewood and Ridgewood with total cost: $" + minCost);
            return "Ridgewood and Bridgewood";
        } else if (minCost == total[0]) {
            System.out.println("Lakewood with total cost: $" + minCost);
            return "Lakewood";
        } else if (minCost == total[1]) {
            System.out.println("Bridgewood with total cost: $" + minCost);
            return "Bridgewood";
        } else {
            System.out.println("Ridgewood with total cost: $" + minCost);
            return "Ridgewood";
        }
    }

}

//
//    public static void main(String[] args) {
//        System.out.println("***Welcome to hotel reservation program***");
//        HotelReservation h = new HotelReservation();
//
//        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90);
//        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50);
//        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150);
//        h.addHotel(lakewood);
//        h.addHotel(bridgewood);
//        h.addHotel(ridgewood);
//        LocalDate startDate = LocalDate.of(2020, Month.SEPTEMBER, 11);
//        LocalDate endDate = LocalDate.of(2020, Month.SEPTEMBER, 12);
//        long noOfDays = ChronoUnit.DAYS.between(startDate, endDate);
//        System.out.println(h.getCheapestHotelBasedOnWeekDayWeekEnd(startDate, endDate));
//    }




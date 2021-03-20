package com.bridgelabs;

import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class HotelReservation<minRate> implements IHotel {
    public static final int LAKEWOOD_RATING = 3;
    public static final int BRIDGEWOOD_RATING = 4;
    public static final int RIDGEWOOD_RATING = 5;
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

    public String  getCheapestHotelBasedOnRating(LocalDate startDate, LocalDate endDate) {
        long noOfDays = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("No of days between the days are:" + (int) noOfDays);
        Integer total[] = new Integer[3];
        int i = 0;
        for (HotelDetails hotel : hotels) {
            total[i] = (int) noOfDays * (hotel.getRegularCustomerWeekDayRate() + hotel.getRegularCustomerWeekEndRate());
            i++;
        }
        //total[0]:Lakewood, total[1]:Bridgewood, total[2]:Ridgewood
        int minCost = Math.min(total[0], Math.min(total[1], total[2]));
        if (minCost == total[0] && minCost == total[1]) {
            String res= LAKEWOOD_RATING > BRIDGEWOOD_RATING ? "Lakewood" : "Bridgewood";
            System.out.println("Cheapest hotel based on racting = " +res + " min cost = " +minCost);
            return res;

        } else if (minCost == total[0] && minCost == total[2]) {
            System.out.println("Total cost: $" + minCost);
            String res = LAKEWOOD_RATING > RIDGEWOOD_RATING ? "Lakewood" : "Ridgewood";
            System.out.println("Cheapest hotel based on racting = " +res + " min cost = " +minCost);
            return res;

        } else if (minCost == total[1] && minCost == total[2]) {
            System.out.println(" Total cost: $" + minCost);
            String res = BRIDGEWOOD_RATING > RIDGEWOOD_RATING ? "Bridgewood" : "Ridgewood";
            System.out.println("Cheapest hotel based on rating = " +res + " min cost = " +minCost);
            return res;

        } else if (minCost == total[0]) {
            System.out.println("Cheapest hotel based on is  Lakewood with min Cost of  " +minCost);

            return "Lakewood";
        } else if (minCost == total[1]) {
            System.out.println("Cheapest hotel based on is  Bridgewood with min Cost of  " +minCost);
            return "Brigewood";
        } else {
            System.out.println("Cheapest hotel based on is  Ridgewood with min Cost of  " +minCost);
            return "Ridgewood";
        }
    }

}




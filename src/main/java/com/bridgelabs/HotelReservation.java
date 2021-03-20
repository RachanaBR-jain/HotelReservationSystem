package com.bridgelabs;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.temporal.ChronoUnit;

public  class HotelReservation implements IHotel {
    public static List<IHotelReservationSystem> hotels = new ArrayList<>();
    public static final int LAKEWOOD_RATING = 3;
    public static final int BRIDGEWOOD_RATING = 4;
    public static final int RIDGEWOOD_RATING = 5;
    public static List<IRegularCustomer> hotelsRegular;
    public static List<IRewardCustomer> hotelsReward;

    public HotelReservation() {
        hotelsRegular = new ArrayList<>();
        hotelsReward = new ArrayList<>();
    }

    public List<IRegularCustomer> addHotel_Regular(IRegularCustomer hotel) {
        hotelsRegular.add(hotel);
        return hotelsRegular;
    }

    public List<IRewardCustomer> addHotel_Reward(IRewardCustomer hotel) {
        hotelsReward.add(hotel);
        return hotelsReward;
    }

    public String getCheapAndBestHotel(LocalDate startDate, LocalDate endDate) {
        long noOfDays = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Number of days: " + (int) noOfDays);
        Integer total[] = new Integer[3]; //total[0]:Lakewood, total[1]:Bridgewood, total[2]:Ridgewood
        int i = 0;
        String loyality = new String();
        if (loyality.equals("Regular"))
            hotels.addAll(hotelsRegular);
        else
            hotels.addAll(hotelsReward);

        for (IHotelReservationSystem hd : hotels) {
            IRewardCustomer hd1 = (IRewardCustomer) hd;
            total[i] = (int) noOfDays * (hd1.getRewardCustomerWeekDayRate() + hd1.getRewardCustomerWeekEndRate());
            i++;
        }
        int minCost = Math.min(total[0], Math.min(total[1], total[2]));
        if (minCost == total[0] && minCost == total[1]) {
            System.out.println("Total cost: $" + minCost);
            return LAKEWOOD_RATING > BRIDGEWOOD_RATING ? "Lakewood" : "Bridgewood";
        } else if (minCost == total[0] && minCost == total[2]) {
            System.out.println("Total cost: $" + minCost);
            return LAKEWOOD_RATING > RIDGEWOOD_RATING ? "Lakewood" : "Ridgewood";
        } else if (minCost == total[1] && minCost == total[2]) {
            System.out.println("Total cost: $" + minCost);
            return BRIDGEWOOD_RATING > RIDGEWOOD_RATING ? "Bridgewood" : "Ridgewood";
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

    public String bestRatedHotel() {
        int maxRating = Math.max(LAKEWOOD_RATING, Math.max(BRIDGEWOOD_RATING, RIDGEWOOD_RATING));
        if (maxRating == LAKEWOOD_RATING)
            return "Lakewood";
        else if (maxRating == BRIDGEWOOD_RATING)
            return "Bridgewood";
        else
            return "Ridgewood";
    }

}
//    public static void main( String[] args )
//    {
//        System.out.println( "***Welcome to hotel reservation program***" );
//        HotelReservation h=new HotelReservation();
//    HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90, 80, 80, 3);
//    HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50, 110, 50, 4);
//    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 100, 40, 5);
//
//        h.addHotel_Reward((IRewardCustomer) lakewood);
//        h.addHotel_Reward((IRewardCustomer)bridgewood);
//        h.addHotel_Reward((IRewardCustomer)ridgewood);
//
//        LocalDate startDate=LocalDate.of(2020, Month.SEPTEMBER, 11);
//        LocalDate endDate=LocalDate.of(2020, Month.SEPTEMBER, 12);
//        long noOfDays=ChronoUnit.DAYS.between(startDate,endDate);
//        System.out.println("Number of days: "+(int)noOfDays);
//       // System.out.println("Cheapest best rated hotel for regular customers: "+h.findCheapestHotel((int)noOfDays,"Regular"));
//        System.out.println("Best rated hotel: "+h.bestRatedHotel());
//        System.out.println("Cheapest best rated hotel for reward customers: "+h.getCheapAndBestHotel(startDate,endDate));
//    }






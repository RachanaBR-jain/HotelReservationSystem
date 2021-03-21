package com.bridgelabs;

import com.bridgelabs.HotelReservationException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

@FunctionalInterface
interface CheckValidation {
    boolean validation(String str) throws HotelReservationException;
}

public class HotelReservation implements IHotel {
    private static final Pattern CHECK_CUSTOMER_TYPE = Pattern.compile("^[A-Za-z]+$");
    private static final Pattern CHECK_DATE_RANGE = Pattern.compile("^[0-9,-]+$");

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

    CheckValidation checkNullEmpty = (data) -> {
        try {
            if (data.length() == 0)
                throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_EMPTY,
                        "Enter proper value");
        } catch (NullPointerException e) {
            throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_NULL,
                    "Enter proper value");
        }
        return true;
    };

    CheckValidation checkCustTypeValidation = (String custType) -> {
        checkNullEmpty.validation(custType);
        boolean valid = CHECK_CUSTOMER_TYPE.matcher(custType).matches();
        if (!valid) {
            throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_INVALID,
                    "Invalid entry, should contains only alphabets");
        }
        return valid;
    };

    CheckValidation checkDateRangeValidation = (String dateRange) -> {
        checkNullEmpty.validation(dateRange);
        boolean valid = CHECK_DATE_RANGE.matcher(dateRange).matches();
        if (!valid) {
            throw new HotelReservationException(HotelReservationException.ExceptionType.ENTERED_INVALID,
                    "Invalid entry, date range should meet format YYYY-MM-DD");
        }
        return valid;
    };

    public String getCheapestHotel(String input, String loyalty) {
        String arr[] = input.split(",");
        int numOfWeekdays = 0;
        int numOfWeekends = 0;
        for (int i = 0; i < arr.length; i++) {
            LocalDate date = LocalDate.parse(arr[i]);
            if (getDayNumber(date) == 6 || getDayNumber(date) == 7)
                numOfWeekends++;
            else
                numOfWeekdays++;
        }
        Integer total[] = new Integer[3]; // total[0]:LakewoodCost, total[1]:BridgewoodCost, total[2]:RidgewoodCost
        int i = 0;
        if (loyalty.equals("Regular"))
            hotels.addAll(hotelsRegular);
        else
            hotels.addAll(hotelsReward);


        for (IHotelReservationSystem hd : hotels) {
            IRewardCustomer hd1 = (IRewardCustomer) hd;
            total[i] = numOfWeekdays * (hd1.getRewardCustomerWeekDayRate() + hd1.getRewardCustomerWeekEndRate());
            i++;
        }
        int minCost = Arrays.asList(total).stream().min(Comparator.naturalOrder()).get();
        if (minCost == total[0] && minCost == total[1]) {
            System.out.println("Total cost: $" + minCost + " for Lakewood and Bridgewood");
            return LAKEWOOD_RATING > BRIDGEWOOD_RATING ? "Lakewood" : "Bridgewood";
        } else if (minCost == total[0] && minCost == total[2]) {
            System.out.println("Total cost: $" + minCost + " for Lakewood and Ridgewood");
            return LAKEWOOD_RATING > RIDGEWOOD_RATING ? "Lakewood" : "Ridgewood";
        } else if (minCost == total[1] && minCost == total[2]) {
            System.out.println("Total cost: $" + minCost + " for Ridgewood and Bridgewood");
            return BRIDGEWOOD_RATING > RIDGEWOOD_RATING ? "Bridgewood" : "Ridgewood";
        } else if (minCost == total[0]) {
            System.out.println("Lakewood with total cost: $" + minCost + ",  Rating: " + LAKEWOOD_RATING);
            return "Lakewood";
        } else if (minCost == total[1]) {
            System.out.println("Bridgewood with total cost: $" + minCost + ",  Rating: " + BRIDGEWOOD_RATING);
            return "Bridgewood";
        } else {
            System.out.println("Ridgewood with total cost: $" + minCost + ",  Rating: " + RIDGEWOOD_RATING);
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

    // Monday is 1 and Sunday is 7
    public int getDayNumber(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }

    public static void main(String[] args) {
        System.out.println("***Welcome to hotel reservation program***");
        HotelReservation h = new HotelReservation();
        HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90, 80, 80, 3);
        HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50, 110, 50, 4);
        HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 100, 40, 5);

        h.addHotel_Reward((IRewardCustomer) lakewood);
        h.addHotel_Reward((IRewardCustomer) bridgewood);
        h.addHotel_Reward((IRewardCustomer) ridgewood);

    }
}






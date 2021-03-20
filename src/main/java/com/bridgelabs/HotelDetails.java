package com.bridgelabs;

import java.util.List;

public class HotelDetails implements Comparable {

    private String hotelName;
    private int regularCustomerWeekDayRate;
    private int regularCustomerWeekEndRate;
    private int rating;
    public HotelDetails(String hotelName, int regularCustomerWeekDayRate, int regularCustomerWeekEndRate,int rating) {
        this.hotelName = hotelName;
        this.regularCustomerWeekDayRate = regularCustomerWeekDayRate;
        this.regularCustomerWeekEndRate = regularCustomerWeekEndRate;
        this.rating =rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRegularCustomerWeekDayRate() {
        return regularCustomerWeekDayRate;
    }

    public int getRegularCustomerWeekEndRate() {
        return regularCustomerWeekEndRate;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setRegularCustomerWeekDayRate(int regularCustomerWeekDayRate) {
        this.regularCustomerWeekDayRate = regularCustomerWeekDayRate;
    }

    public void setRegularCustomerWeekEndRate(int regularCustomerWeekEndRate) {
        this.regularCustomerWeekEndRate = regularCustomerWeekEndRate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return " HotelDetails--->" +
                "hotelName=" + hotelName + " regularCustomerWeekDayRate=" + regularCustomerWeekDayRate +
                " regularCustomerWeekEndRate=" + regularCustomerWeekEndRate + " rating = " + rating + " \n ";
    }

    @Override
    public int compareTo(Object o) {
        int compareRate = ((HotelDetails) o).regularCustomerWeekDayRate;
        return this.regularCustomerWeekDayRate - compareRate;
    }
}
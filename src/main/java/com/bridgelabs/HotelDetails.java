package com.bridgelabs;

public class HotelDetails implements Comparable, IRewardCostomer, IRegularCostomer {

    private String hotelName;
    private int regularCustomerWeekDayRate;
    private int regularCustomerWeekEndRate;
    private int rewardCustomerWeekDayRate;
    private int rewardCustomerWeekEndRate;
    private int rating;

    public HotelDetails(String hotelName, int regularCustomerWeekDayRate, int regularCustomerWeekEndRate, int rewardCustomerWeekDayRate, int rewardCustomerWeekEndRate, int rating) {
        this.hotelName = hotelName;
        this.regularCustomerWeekDayRate = regularCustomerWeekDayRate;
        this.regularCustomerWeekEndRate = regularCustomerWeekEndRate;
        this.rewardCustomerWeekDayRate = rewardCustomerWeekDayRate;
        this.rewardCustomerWeekEndRate = rewardCustomerWeekEndRate;
        this.rating = rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRegularCustomerWeekDayRate() {
        return regularCustomerWeekDayRate;
    }

    public void setRegularCustomerWeekDayRate(int regularCustomerWeekDayRate) {
        this.regularCustomerWeekDayRate = regularCustomerWeekDayRate;
    }

    public int getRegularCustomerWeekEndRate() {
        return regularCustomerWeekEndRate;
    }

    public void setRegularCustomerWeekEndRate(int regularCustomerWeekEndRate) {
        this.regularCustomerWeekEndRate = regularCustomerWeekEndRate;
    }

    public int getRewardCustomerWeekDayRate() {
        return rewardCustomerWeekDayRate;
    }

    public void setRewardCustomerWeekDayRate(int rewardCustomerWeekDayRate) {
        this.rewardCustomerWeekDayRate = rewardCustomerWeekDayRate;
    }

    public int getRewardCustomerWeekEndRate() {
        return rewardCustomerWeekEndRate;
    }

    public void setRewardCustomerWeekEndRate(int rewardCustomerWeekEndRate) {
        this.rewardCustomerWeekEndRate = rewardCustomerWeekEndRate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "HotelDetails--->" +
                "hotelName='" + hotelName + '\'' +
                ", regularCustomerWeekDayRate=" + regularCustomerWeekDayRate +
                ", regularCustomerWeekEndRate=" + regularCustomerWeekEndRate +
                ", rewardCustomerWeekDayRate=" + rewardCustomerWeekDayRate +
                ", rewardCustomerWeekEndRate=" + rewardCustomerWeekEndRate +
                ", rating=" + rating + "\n";
    }

    @Override
    public int compareTo(Object o) {
        int compareRate = ((HotelDetails) o).regularCustomerWeekDayRate;
        return this.regularCustomerWeekDayRate - compareRate;
    }
}
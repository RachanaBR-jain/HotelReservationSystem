package com.bridgelabs;

public class HotelDetails  {
    private String hotelName;
    private int regularCustomerWeekDayRate;

    public HotelDetails(String hotelName, int regularCustomerWeekDayRate) {
        this.hotelName = hotelName;
        this.regularCustomerWeekDayRate = regularCustomerWeekDayRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRegularCustomerWeekDayRate() {
        return regularCustomerWeekDayRate;
    }


    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setRegularCustomerWeekDayRate(int regularCustomerWeekDayRate) {
        this.regularCustomerWeekDayRate = regularCustomerWeekDayRate;
    }

    @Override
    public String toString() {
        return " HotelDetails--->" +
                "hotelName=" + hotelName + " regularCustomerWeekDayRate=" + regularCustomerWeekDayRate + "\n ";

    }

}



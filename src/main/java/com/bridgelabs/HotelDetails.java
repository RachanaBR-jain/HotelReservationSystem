package com.bridgelabs;

public class HotelDetails {
        private String hotelName;
        private int regularCustomerWeekDayRate;
        private int regularCustomerWeekEndRate;

        public HotelDetails(String hotelName, int regularCustomerWeekDayRate, int regularCustomerWeekEndRate) {
            this.hotelName = hotelName;
            this.regularCustomerWeekDayRate = regularCustomerWeekDayRate;
            this.regularCustomerWeekEndRate = regularCustomerWeekEndRate;
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

    @Override
    public String toString() {
        return " HotelDetails--->" +
                "hotelName=" + hotelName + " regularCustomerWeekDayRate=" + regularCustomerWeekDayRate +
                " regularCustomerWeekEndRate=" + regularCustomerWeekEndRate + " \n ";
    }
}

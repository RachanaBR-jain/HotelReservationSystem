package com.bridgelabs;

public interface IRegularCostomer {
    public String getHotelName();

    public void setHotelName(String hotelName);

    public void setRegularCustomerWeekDayRate(int regularCustomerWeekDayRate);

    public int getRegularCustomerWeekDayRate();

    public void setRegularCustomerWeekEndRate(int regularCustomerWeekEndRate);

    public int getRegularCustomerWeekEndRate();
}

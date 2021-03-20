package com.bridgelabs;

public interface IRegularCostomer extends IHotelDetails {


    public void setRegularCustomerWeekDayRate(int regularCustomerWeekDayRate);

    public int getRegularCustomerWeekDayRate();

    public void setRegularCustomerWeekEndRate(int regularCustomerWeekEndRate);

    public int getRegularCustomerWeekEndRate();
}

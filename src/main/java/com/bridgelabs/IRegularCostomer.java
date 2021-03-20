package com.bridgelabs;

interface IRegularCustomer extends IHotelReservationSystem {


    public void setRegularCustomerWeekDayRate(int regularCustomerWeekDayRate);

    public int getRegularCustomerWeekDayRate();

    public void setRegularCustomerWeekEndRate(int regularCustomerWeekEndRate);

    public int getRegularCustomerWeekEndRate();
    public String getHotelName();

    public void setHotelName(String hotelName);

    public int getRating();

    public void setRating(int rating);
}

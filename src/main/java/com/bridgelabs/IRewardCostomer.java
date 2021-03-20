package com.bridgelabs;

interface IRewardCustomer extends IHotelReservationSystem  {

    public void setRewardCustomerWeekDayRate(int rewardCustomerWeekDayRate);

    public int getRewardCustomerWeekDayRate();

    public void setRewardCustomerWeekEndRate(int rewardCustomerWeekEndRate);

    public int getRewardCustomerWeekEndRate();
    public String getHotelName();

    public void setHotelName(String hotelName);

    public int getRating();

    public void setRating(int rating);

}

package com.bridgelabs;

import java.util.List;

interface IHotel {
    public List<IRegularCustomer> addHotel_Regular(IRegularCustomer hotel);

    public List<IRewardCustomer> addHotel_Reward(IRewardCustomer hotel);

    public String getCheapestHotel(String input, String loyalty) throws HotelReservationException;

    public String bestRatedHotel() throws HotelReservationException;


}

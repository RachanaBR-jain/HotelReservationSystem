package com.bridgelabs;

import java.time.LocalDate;
import java.util.List;

interface IHotel extends IHotelReservationSystem {
    public List<IRegularCustomer> addHotel_Regular(IRegularCustomer hotel);

    public List<IRewardCustomer> addHotel_Reward(IRewardCustomer hotel);

    public  String getCheapAndBestHotel(LocalDate startDate, LocalDate endDate);

    public  String bestRatedHotel();

}

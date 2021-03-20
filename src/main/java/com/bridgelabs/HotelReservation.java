package com.bridgelabs;

import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class HotelReservation implements IHotel {

    public static final int LAKEWOOD_RATING = 3;
    public static final int BRIDGEWOOD_RATING = 4;
    public static final int RIDGEWOOD_RATING = 5;
    public static List<IRegularCostomer> hotelsRegular = new ArrayList<>();
    public static List<IRewardCostomer> hotelsReward = new ArrayList<>();

    public List<IRegularCostomer> addHotel_Regular(IRegularCostomer hotel){
       hotelsRegular.add(hotel);
       return hotelsRegular;
    }
    public List<IRewardCostomer> addHotel_Reward(IRewardCostomer hotel){
        hotelsReward.add(hotel);
        return hotelsReward;
    }


}




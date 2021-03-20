package com.bridgelabs;

import java.time.LocalDate;
import java.util.List;

interface IHotel {
    public List<IRegularCostomer> addHotel_Regular(IRegularCostomer hotel);
    public List<IRewardCostomer> addHotel_Reward(IRewardCostomer hotel);

}

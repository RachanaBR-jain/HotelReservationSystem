package com.bridgelabs;

import java.time.LocalDate;
import java.util.List;

interface IHotel {
    List<HotelDetails> addHotel(HotelDetails hotel);

    String getCheapestHotel(LocalDate startDate, LocalDate lastDate);

    String getCheapestHotelBasedOnWeekDayWeekEnd(LocalDate stateDate, LocalDate endDate);

    String getCheapestHotelBasedOnRating(LocalDate startDate, LocalDate endDate);

}

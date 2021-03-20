package com.bridgelabs;

import java.time.LocalDate;
import java.util.List;

interface IHotel {
    public List<HotelDetails> addHotel(HotelDetails hotel);

    String findCheapestHotel(LocalDate startDate, LocalDate lastDate);
}

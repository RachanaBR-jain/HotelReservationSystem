package com.bridgelabs;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation implements IHotel{
    public static List<HotelDetails> hotels;

    public HotelReservation() {
        hotels = new ArrayList<>();
    }
    public List<HotelDetails> addHotel(HotelDetails hotel) {
        hotels.add(hotel);
        return hotels;
    }

    public static void main(String[] args) {
        System.out.println("***Welcome to hotel reservation program***");

    }

}

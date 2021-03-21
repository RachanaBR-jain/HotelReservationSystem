package com.bridgelabs;

import com.bridgelabs.HotelReservationException;
import junit.framework.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class HotelReservationTesting {

    IHotel hotelReservation;
    HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90, 80, 80, 3);
    HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50, 110, 50, 4);
    HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150, 100, 40, 5);


    @BeforeEach
    public void initial() {
        hotelReservation = new HotelReservation();
        hotelReservation.addHotel_Reward((IRewardCustomer) lakewood);
        hotelReservation.addHotel_Reward((IRewardCustomer) bridgewood);
        hotelReservation.addHotel_Reward((IRewardCustomer) ridgewood);

        hotelReservation.addHotel_Regular((IRegularCustomer) lakewood);
        hotelReservation.addHotel_Regular((IRegularCustomer) bridgewood);
        hotelReservation.addHotel_Regular((IRegularCustomer) ridgewood);
    }

    @Test
    public void givenWeekDayAndWeekEndRatesOf_Regular_RewardCostomer_mustReturnTrue() {
        System.out.println(HotelReservation.hotelsReward);
        Assertions.assertTrue(HotelReservation.hotelsReward.contains(lakewood));
    }

    @Test
    public void givenDateRange_WhenHotelProper_ShouldReturnTrue() throws HotelReservationException {
        // String input1 ="2020-09-10,2020-09-11"; // YYYY-MM-DD format
        String input = "2020-09-11,2020-09-12";
        String bestRated = hotelReservation.bestRatedHotel();
        System.out.println("Best rated hotel: " + hotelReservation.bestRatedHotel());
        System.out.println("Cheapest best rated hotel for reward customers: " + hotelReservation.getCheapestHotel(input, "Reward"));
        Assertions.assertEquals("Ridgewood", bestRated);
    }


    @Test
    public void givenCustomerType_WhenProper_ShouldReturnTrue() {
        HotelReservation validator = new HotelReservation();
        boolean result;
        try {
            result = validator.checkCustTypeValidation.validation("Regular");
            System.out.println(result);
            Assertions.assertEquals(true, result);
        } catch (HotelReservationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenCustomerType_WhenNull_ShouldThrowNullException() {
        HotelReservation validator = new HotelReservation();
        boolean result;
        try {
            result = validator.checkCustTypeValidation.validation(null);
        } catch (HotelReservationException e) {
            System.out.println(e.getMessage());
            System.out.println(e.exceptionType);
            Assertions.assertEquals("Enter proper value", e.getMessage());
            Assertions.assertEquals(HotelReservationException.ExceptionType.ENTERED_NULL, e.exceptionType);
        }
    }

    @Test
    public void givenCustomerType_WhenEmpty_ShouldThrowEmptyException() {
        HotelReservation validator = new HotelReservation();
        boolean result;
        try {
            result = validator.checkCustTypeValidation.validation("");
        } catch (HotelReservationException e) {
            System.out.println(e.getMessage());
            System.out.println(e.exceptionType);
            Assertions.assertEquals("Enter proper value", e.getMessage());
            Assertions.assertEquals(HotelReservationException.ExceptionType.ENTERED_EMPTY, e.exceptionType);
        }
    }

    @Test
    public void givenCustomerType_WhenInvalid_ShouldThrowInvalidException() {
        HotelReservation validator = new HotelReservation();
        boolean result;
        try {
            result = validator.checkCustTypeValidation.validation("Reg_ular");
        } catch (HotelReservationException e) {
            System.out.println(e.getMessage());
            System.out.println(e.exceptionType);
            Assertions.assertEquals("Invalid entry, should contains only alphabets", e.getMessage());
            Assertions.assertEquals(HotelReservationException.ExceptionType.ENTERED_INVALID, e.exceptionType);
        }
    }
    @Test
    public void givenDateRange_WhenProper_ShouldReturnTrue() {
        HotelReservation validator = new HotelReservation();
        boolean result;
        try {
            result = validator.checkDateRangeValidation.validation("2020-09-10,2020-09-11");
            Assertions.assertEquals(true, result);
        } catch (HotelReservationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenDateRange_WhenNull_ShouldThrowNullException() {
        HotelReservation validator = new HotelReservation();
        boolean result;
        try {
            result = validator.checkDateRangeValidation.validation(null);
        } catch (HotelReservationException e) {
            System.out.println(e.getMessage());
            System.out.println(e.exceptionType);
            Assertions.assertEquals("Enter proper value", e.getMessage());
            Assertions.assertEquals(HotelReservationException.ExceptionType.ENTERED_NULL, e.exceptionType);
        }
    }

    @Test
    public void givenDateRange_WhenEmpty_ShouldThrowEmptyException() {
        HotelReservation validator = new HotelReservation();
        boolean result;
        try {
            result = validator.checkDateRangeValidation.validation("");
        } catch (HotelReservationException e) {
            System.out.println(e.getMessage());
            System.out.println(e.exceptionType);
            Assertions.assertEquals("Enter proper value", e.getMessage());
            Assertions.assertEquals(HotelReservationException.ExceptionType.ENTERED_EMPTY, e.exceptionType);
        }
    }

    @Test
    public void givenDateRange_WhenInvalid_ShouldThrowInvalidException() {
        HotelReservation validator = new HotelReservation();
        boolean result;
        try {
            result = validator.checkDateRangeValidation.validation("2020-aug-04,2020-5-14");
        } catch (HotelReservationException e) {
            System.out.println(e.getMessage());
            System.out.println(e.exceptionType);
            Assertions.assertEquals("Invalid entry, date range should meet format YYYY-MM-DD", e.getMessage());
            Assertions.assertEquals(HotelReservationException.ExceptionType.ENTERED_INVALID, e.exceptionType);
        }
    }

}

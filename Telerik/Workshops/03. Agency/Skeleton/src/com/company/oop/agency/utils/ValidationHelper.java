package com.company.oop.agency.utils;

import com.company.oop.agency.exceptions.InvalidUserInputException;

import java.util.List;

public class ValidationHelper {

    public static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. Expected: %0.f, Received: %0.f";
    private static final String INVALID_PASSENGER_CAPACITY = "cannot have less than %.0f passengers or more than %.0f passengers.";
    private static final String INVALID_CARTS_NUMBER = "A train cannot have less than %0.f cart or more than %0.f carts.";
    private static final String STRING_LENGTH_ERROR = "length cannot be less than %.0f or more than %.0f symbols long.";
    private static final String INVALID_PRICE_PER_KILOMETER = "with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!";
    private static final String INVALID_DISTANCE_NUMBER = "The Distance cannot be less than %0.f or more than %0.f kilometers.";
    private static final String INVALID_COSTS_NUMBER = "Value of 'costs' must be a positive number. Actual value:";


    public static void validateValueInRange(double value, double min, double max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(String.format(errorMessage, min, max));
        }
    }

    public static void validateStringLength(String stringToValidate, int minLength, int maxLength, String type) {
        String errorMessage = String.format("The %s %s", type, STRING_LENGTH_ERROR);

        validateValueInRange(stringToValidate.length(), minLength, maxLength, errorMessage);
    }

    public static void validateArgumentsCount(List<String> list, int expectedArgumentsCount) {
        if (list.size() < expectedArgumentsCount || list.size() > expectedArgumentsCount) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, expectedArgumentsCount, list.size()));
        }
    }


    public static void validateCartsNumber(int cartsNumber, int min, int max) {
        validateValueInRange(cartsNumber, min, max, INVALID_CARTS_NUMBER);
    }

    public static void validatePassengerCapacity(int passengerCapacity, int minimumCapacity, int maximumCapacity, String vehicleType) {
        String errorMessage = String.format("A %s %s", vehicleType, INVALID_PASSENGER_CAPACITY);

        validateValueInRange(passengerCapacity, minimumCapacity, maximumCapacity, errorMessage);
    }

    public static void validatePricePerKilometer(double pricePerKilometer, double minPricePerKil, double maxPricePerKil, String vehicleType) {
        String errorMessage = String.format("A %s %s", vehicleType, INVALID_PRICE_PER_KILOMETER);

        validateValueInRange(pricePerKilometer, minPricePerKil, maxPricePerKil, errorMessage);
    }

    public static void validateDistance(int distance, double minDistance, double maxDistance) {
        validateValueInRange(distance, minDistance, maxDistance, INVALID_DISTANCE_NUMBER);
    }

    public static void validateCosts(double cost) {
        if (cost < 0.00) {
            throw new InvalidUserInputException(String.format("%s %.2f.", INVALID_COSTS_NUMBER, cost));
        }
    }

}
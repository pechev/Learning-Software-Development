package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class VehicleImpl implements Vehicle {
    private static final int PASSENGER_MIN_VALUE = 1;
    private static final int PASSENGER_MAX_VALUE = 800;
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    private final int id;
    private int passengerCapacity;
    private final VehicleType vehicleType;
    private double pricePerKilometer;

    protected VehicleImpl(int id, int passengerCapacity, VehicleType vehicleType, double pricePerKilometer) {
        this.id = id;
        setPassengerCapacity(passengerCapacity);
        this.vehicleType = vehicleType;
        setPricePerKilometer(pricePerKilometer);
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);

        this.pricePerKilometer = pricePerKilometer;
    }


    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);

        this.passengerCapacity = passengerCapacity;
    }

    protected void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validatePassengerCapacity(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE, "vehicle");
    }

    protected void validatePricePerKilometer(double pricePerKilometer) {
        ValidationHelper.validatePricePerKilometer(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE, "vehicle");
    }

    @Override
    public String toString() {

        return "Passenger capacity: " + passengerCapacity + System.lineSeparator() +
                "Price per kilometer: " + pricePerKilometer + System.lineSeparator() +
                "Vehicle type: " + vehicleType;
    }

    @Override
    public String getAsString() {
        return "Passenger capacity: " + passengerCapacity + System.lineSeparator() +
                "Price per kilometer: " + pricePerKilometer + System.lineSeparator() +
                "Vehicle type: " + vehicleType;
    }

    @Override
    public VehicleType getType() {
        return vehicleType;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    @Override
    public int getId() {
        return id;
    }
}

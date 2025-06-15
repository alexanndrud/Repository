package com.project.Project.Calculator.model;

public class IncomeRequest {
    private int hoursPerDay;
    private int daysPerWeek;
    private String vehicleType;
    private double fuelCost;
    private double fleetCommission;

    // Getters și Setters
    public int getHoursPerDay() { return hoursPerDay; }
    public void setHoursPerDay(int hoursPerDay) { this.hoursPerDay = hoursPerDay; }

    public int getDaysPerWeek() { return daysPerWeek; }
    public void setDaysPerWeek(int daysPerWeek) { this.daysPerWeek = daysPerWeek; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public double getFuelCost() { return fuelCost; }
    public void setFuelCost(double fuelCost) { this.fuelCost = fuelCost; }

    public double getFleetCommission() { return fleetCommission; }
    public void setFleetCommission(double fleetCommission) { this.fleetCommission = fleetCommission; }
}


package com.project.Project.Calculator.service;

import com.project.Project.Calculator.model.IncomeRequest;
import org.springframework.stereotype.Service;

@Service
public class IncomeCalculatorService {

    public double calculateIncome(IncomeRequest request) {
        double hourlyRateRON = switch (request.getVehicleType()) {
            case "Electric" -> 80.0;
            case "Combustie" -> 60.0;
            case "Premium" -> 75.0;
            default -> 60.0;
        };

        // Calcul venit brut lunar
        double grossIncome = request.getHoursPerDay() * request.getDaysPerWeek() * hourlyRateRON * 4;

        // Costuri combustibil (deja în RON)
        double fuelExpenses = request.getFuelCost() * request.getHoursPerDay() * request.getDaysPerWeek() * 4;

        // Comision flotă
        double fleetCut = grossIncome * (request.getFleetCommission() / 100);

        // Venitul net final în RON
        return grossIncome - fuelExpenses - fleetCut;
    }
}


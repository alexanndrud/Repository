package com.project.Project.Calculator.controller;

import com.project.Project.Calculator.model.IncomeRequest;
import com.project.Project.Calculator.service.IncomeCalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calculator")
public class IncomeCalculatorController {

    private final IncomeCalculatorService calculatorService;

    public IncomeCalculatorController(IncomeCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showCalculatorForm() {
        return "calculator";
    }

    @PostMapping
    public String calculateIncome(@ModelAttribute IncomeRequest request, Model model) {
        double estimatedIncome = calculatorService.calculateIncome(request);
        model.addAttribute("estimatedIncome", estimatedIncome);
        return "calculator";
    }
}

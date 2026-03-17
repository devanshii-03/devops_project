package com.moneymanager.report;

import java.util.List;

public class ReportService {

  public double calculateTotalExpense(List<Double> expenses) {
    double total = 0;
    for (double expense : expenses) {
      total += expense;
    }
    return total;
  }

  public void generateSimpleReport() {
    System.out.println("Category: Food Amount: 3000.0");
    System.out.println("Category: Travel Amount: 2000.0");
    System.out.println("Balance: 10000.0");
    System.out.println("Savings: 10000.0");
  }

  public double calculateSavings(double income, double expense) {
    return income - expense;
  }

  public String generateSummary(double income, double expense) {
    double savings = calculateSavings(income, expense);

    return "Income: " + income +
        "\nExpense: " + expense +
        "\nSavings: " + savings;
  }
}
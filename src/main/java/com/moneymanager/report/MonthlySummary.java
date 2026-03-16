package com.moneymanager.report;

public class MonthlySummary {

  private double totalIncome;
  private double totalExpense;

  public MonthlySummary(double totalIncome, double totalExpense) {
    this.totalIncome = totalIncome;
    this.totalExpense = totalExpense;
  }

  public double getSavings() {
    return totalIncome - totalExpense;
  }
}
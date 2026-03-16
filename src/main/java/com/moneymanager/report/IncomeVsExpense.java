package com.moneymanager.report;

public class IncomeVsExpense {

  private double income;
  private double expense;

  public IncomeVsExpense(double income, double expense) {
    this.income = income;
    this.expense = expense;
  }

  public double getBalance() {
    return income - expense;
  }
}
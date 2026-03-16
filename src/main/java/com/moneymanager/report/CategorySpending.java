package com.moneymanager.report;

public class CategorySpending {

  private String category;
  private double amount;

  public CategorySpending(String category, double amount) {
    this.category = category;
    this.amount = amount;
  }

  public String getCategory() {
    return category;
  }

  public double getAmount() {
    return amount;
  }
}
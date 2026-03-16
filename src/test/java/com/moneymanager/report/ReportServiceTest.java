package com.moneymanager.report;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReportServiceTest {

  // Calculate total expense
  public double calculateTotalExpense(List<Double> expenses) {
    double total = 0;

    for (double expense : expenses) {
      total += expense;
    }

    return total;
  }

  // Calculate savings
  public double calculateSavings(double income, double expense) {
    return income - expense;
  }

  // Generate summary
  public String generateSummary(double income, double expense) {
    double savings = calculateSavings(income, expense);

    return "Income: " + income +
        "\nExpense: " + expense +
        "\nSavings: " + savings;
  }

  // ---------------- TEST CASES ----------------

  @Test
  void testCalculateTotalExpense() {
    List<Double> expenses = Arrays.asList(100.0, 200.0, 300.0);
    double result = calculateTotalExpense(expenses);
    assertEquals(600.0, result);
  }

  @Test
  void testCalculateSavings() {
    double savings = calculateSavings(5000, 2000);
    assertEquals(3000, savings);
  }

  @Test
  void testGenerateSummary() {
    String summary = generateSummary(5000, 2000);
    assertTrue(summary.contains("Income: 5000"));
    assertTrue(summary.contains("Expense: 2000"));
    assertTrue(summary.contains("Savings: 3000"));
  }
}
package com.moneymanager.transact;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    private List<Transaction> transactions = new ArrayList<>();
    private int currentId = 1;

    // Add Transaction
    public Transaction addTransaction(String type,
                                      double amount,
                                      LocalDate date) {

        // Basic Validation
        if (type == null) {
            throw new IllegalArgumentException("Transaction type cannot be null");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }

        Transaction transaction = new Transaction(
                currentId++, type, amount, date);

        transactions.add(transaction);
        return transaction;
    }

    // Delete Transaction by ID
    public void deleteTransaction(int id) {
        Transaction transactionToRemove = transactions.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Transaction with ID " + id + " not found"));

        transactions.remove(transactionToRemove);
    }

    // Get All Transactions
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions); // Defensive copy
    }

    // Get Transactions By Type
    public List<Transaction> getTransactionsByType(String type) {

        if (type == null) {
            throw new IllegalArgumentException("Transaction type cannot be null");
        }

        return transactions.stream()
                .filter(t -> t.getType() == type)
                .collect(Collectors.toList());
    }
}
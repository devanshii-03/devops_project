package com.moneymanager.transact;
import java.time.LocalDate;

public class Transaction {
    private final int id;
    private final String type;
    private final double amount;
    private final LocalDate date;

    public Transaction(int id, String type, double amount, LocalDate date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}

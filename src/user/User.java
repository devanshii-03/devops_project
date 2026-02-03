package src.user;

public class User {

    private String userId;
    private String name;
    private double monthlyBudget;
    private String currency;

    public User(String userId, String name, double monthlyBudget, String currency) {
        this.userId = userId;
        this.name = name;
        this.monthlyBudget = monthlyBudget;
        this.currency = currency;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public String getCurrency() {
        return currency;
    }
}

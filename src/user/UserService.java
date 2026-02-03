package src.user;

import src.common.constants.AppConstants;
import src.common.exceptions.InvalidInputException;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    // In-memory user store (intentional for testing)
    private Map<String, User> users = new HashMap<>();

    /**
     * Creates a new user with a monthly budget.
     */
    public User createUser(String userId, String name, double monthlyBudget, String currency) {

        if (users.containsKey(userId)) {
            throw new InvalidInputException("User already exists");
        }

        validateBudget(monthlyBudget);

        if (currency == null || currency.isEmpty()) {
            currency = AppConstants.DEFAULT_CURRENCY;
        }

        User user = new User(userId, name, monthlyBudget, currency);
        users.put(userId, user);

        return user;
    }

    /**
     * Updates the monthly budget of an existing user.
     */
    public User updateBudget(String userId, double newBudget) {

        validateUserExists(userId);
        validateBudget(newBudget);

        User user = users.get(userId);
        user.setMonthlyBudget(newBudget);

        return user;
    }

    /**
     * Returns user details.
     */
    public User getUser(String userId) {

        validateUserExists(userId);
        return users.get(userId);
    }

    /**
     * Deletes all user data.
     */
    public boolean resetUser(String userId) {

        validateUserExists(userId);
        users.remove(userId);
        return true;
    }

    // -------- Private helper methods --------

    private void validateBudget(double budget) {
        if (budget <= 0) {
            throw new InvalidInputException("Monthly budget must be greater than zero");
        }
    }

    private void validateUserExists(String userId) {
        if (!users.containsKey(userId)) {
            throw new InvalidInputException("User does not exist");
        }
    }
}

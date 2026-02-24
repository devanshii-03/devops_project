package src.main.java.com.moneymanager.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthService {

    private final Map<String, User> users = new HashMap<>();

    // Register new user
    public User registerUser(String username, String password) {

        if (users.containsKey(username)) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User(username, password);
        users.put(username, user);
        return user;
    }

    // Login user
    public boolean login(String username, String password) {

        User user = users.get(username);

        if (user == null) {
            throw new IllegalArgumentException("User does not exist");
        }

        return user.getPassword().equals(password);
    }

    // Check if user exists
    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    // For testing purposes
    public int getUserCount() {
        return users.size();
    }
}
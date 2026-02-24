package src.test.java.com.moneymanager.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.com.moneymanager.auth.AuthService;
import src.main.java.com.moneymanager.auth.User;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService();
    }

    // ----------------------------
    // Registration Tests
    // ----------------------------

    @Test
    void shouldRegisterValidUser() {
        User user = authService.registerUser("devanshi", "pass123");

        assertNotNull(user);
        assertEquals("devanshi", user.getUsername());
        assertEquals(1, authService.getUserCount());
    }

    @Test
    void shouldNotAllowDuplicateUsername() {
        authService.registerUser("devanshi", "pass123");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> authService.registerUser("devanshi", "newpass")
        );

        assertEquals("Username already exists", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForBlankUsername() {
        assertThrows(
                IllegalArgumentException.class,
                () -> authService.registerUser("", "pass123")
        );
    }

    @Test
    void shouldThrowExceptionForShortPassword() {
        assertThrows(
                IllegalArgumentException.class,
                () -> authService.registerUser("user1", "123")
        );
    }

    // ----------------------------
    // Login Tests
    // ----------------------------

    @Test
    void shouldLoginWithCorrectCredentials() {
        authService.registerUser("devanshi", "pass123");

        boolean result = authService.login("devanshi", "pass123");

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseForWrongPassword() {
        authService.registerUser("devanshi", "pass123");

        boolean result = authService.login("devanshi", "wrongpass");

        assertFalse(result);
    }

    @Test
    void shouldThrowExceptionIfUserDoesNotExist() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> authService.login("unknown", "pass123")
        );

        assertEquals("User does not exist", exception.getMessage());
    }

    // ----------------------------
    // Utility Method Tests
    // ----------------------------

    @Test
    void shouldReturnTrueIfUserExists() {
        authService.registerUser("devanshi", "pass123");

        assertTrue(authService.userExists("devanshi"));
    }

    @Test
    void shouldReturnFalseIfUserDoesNotExist() {
        assertFalse(authService.userExists("unknown"));
    }
}
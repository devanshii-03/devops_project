import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class PalindromeTest {
    Palindrome palindrome = new Palindrome();
    @Test
    public void testValidPalindrome() {
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("level"));
        assertTrue(palindrome.isPalindrome("madam"));
        assertTrue(palindrome.isPalindrome("noon"));
    }
    @Test
    public void testInvalidPalindrome() {
        assertFalse(palindrome.isPalindrome("hello"));
        assertFalse(palindrome.isPalindrome("devanshi"));
        assertFalse(palindrome.isPalindrome("world"));
        assertFalse(palindrome.isPalindrome("java"));
    }
    @Test
    public void testEdgeCases() {
        assertTrue(palindrome.isPalindrome("")); // Empty string
        assertTrue(palindrome.isPalindrome("a")); // Single character
        assertTrue(palindrome.isPalindrome("aa")); // Two same characters
        assertFalse(palindrome.isPalindrome("ab")); // Two different characters
    }
}

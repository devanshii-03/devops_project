public class Palindrome {
    public boolean isPalindrome(String s) {
        boolean isPalindrome = true;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Checked palindrome for string: " + s + "\nResult: " + isPalindrome);
        return isPalindrome;
    }
}

import java.util.Stack;

/**
 * UC11: PalindromeChecker
 * Demonstrates Encapsulation and Single Responsibility.
 */
public class PalindromeChecker {

    /**
     * Checks if a given string is a palindrome.
     * Logic: Uses a Stack to reverse the string and compare.
     * * @param input The string to check
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Clean the input: remove non-alphanumeric and convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : cleaned.toCharArray()) {
            stack.push(c);
        }

        // Build the reversed string by popping from the stack
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return cleaned.equals(reversed.toString());
    }

    public static void main(String[] args) {
        PalindromeChecker service = new PalindromeChecker();

        // Test Cases
        String test1 = "Racecar";
        String test2 = "Hello";

        System.out.println("Is '" + test1 + "' a palindrome? " + service.checkPalindrome(test1));
        System.out.println("Is '" + test2 + "' a palindrome? " + service.checkPalindrome(test2));
    }
}
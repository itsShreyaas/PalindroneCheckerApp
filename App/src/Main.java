public class Main {

    public static void main(String[] args) {
        String word = "RACECAR";
        // Normalize the string: lowercase and remove non-alphanumeric if needed
        boolean result = isPalindrome(word.toLowerCase());

        System.out.println("Is '" + word + "' a palindrome? " + result);
    }


    public static boolean isPalindrome(String s) {
        // 1. Base Condition: If the string is empty or has one char, it's a palindrome
        if (s.length() <= 1) {
            return true;
        }

        // 2. Compare the first and last characters
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            // 3. Recursive Call: Slice the string and move inward
            // substring(start, end) is inclusive of start, exclusive of end
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        // If characters don't match, it's not a palindrome
        return false;
    }
}
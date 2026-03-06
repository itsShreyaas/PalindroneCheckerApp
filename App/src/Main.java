class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromChecker {

    // Main Method to run the test
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        String word1 = "RADAR";
        String word2 = "HELLO";

        System.out.println(word1 + " is palindrome: " + checker.isPalindrome(stringToList(word1)));
        System.out.println(word2 + " is palindrome: " + checker.isPalindrome(stringToList(word2)));
    }


    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // 1. Find the middle using Fast and Slow Pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        Node secondHalfHead = reverse(slow);
        Node firstHalfHead = head;

        Node copySecondHalf = secondHalfHead;
        boolean isPalin = true;

        while (copySecondHalf != null) {
            if (firstHalfHead.data != copySecondHalf.data) {
                isPalin = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            copySecondHalf = copySecondHalf.next;
        }

        reverse(secondHalfHead);

        return isPalin;
    }


    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }


    private static Node stringToList(String s) {
        if (s.isEmpty()) return null;
        Node head = new Node(s.charAt(0));
        Node current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new Node(s.charAt(i));
            current = current.next;
        }
        return head;
    }
}
import java.util.Scanner;
import java.util.Stack;

// Service class following OOPS principles
class PalindromeChecker {

    // Public method exposed to users
    public boolean checkPalindrome(String input) {

        // Normalize input (ignore case & spaces)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters onto stack
        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        // Compare original string with reversed (using stack)
        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create object of service class
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("      PALINDROME CHECKER APP");
        System.out.println("      Version 1.0.0");
        System.out.println("=================================\n");

        String input = "madam";

        if (input.equals(new StringBuilder(input).reverse().toString())) {
            System.out.println("UC2: " + input + " is Palindrome");
        } else {
            System.out.println("UC2: " + input + " is NOT Palindrome");
        }

        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        if (input.equals(reversed)) {
            System.out.println("UC3: " + input + " is Palindrome");
        } else {
            System.out.println("UC3: " + input + " is NOT Palindrome");
        }

        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4: " + input + (isPalindrome ? " is Palindrome" : " is NOT Palindrome"));

        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        String stackReverse = "";
        while (!stack.isEmpty()) {
            stackReverse += stack.pop();
        }

        System.out.println("UC5: " + input + (input.equals(stackReverse) ? " is Palindrome" : " is NOT Palindrome"));

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack2.push(c);
        }

        boolean result = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack2.pop())) {
                result = false;
                break;
            }
        }

        System.out.println("UC6: " + input + (result ? " is Palindrome" : " is NOT Palindrome"));

        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean dequeResult = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                dequeResult = false;
                break;
            }
        }

        System.out.println("UC7: " + input + (dequeResult ? " is Palindrome" : " is NOT Palindrome"));
    }
}

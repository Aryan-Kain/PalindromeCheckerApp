import java.util.*;

public class PalindromeCheckerApp {

    // Iterative method
    public static boolean iterativePalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    // Recursive method
    public static boolean recursivePalindrome(String str, int start, int end) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }

    // Stack-based method
    public static boolean stackPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    // Deque-based method
    public static boolean dequePalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : str.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Map to store results
        Map<String, Long> results = new LinkedHashMap<>();

        // Iterative
        long startTime = System.nanoTime();
        iterativePalindrome(input);
        long endTime = System.nanoTime();
        results.put("Iterative", endTime - startTime);

        // Recursive
        startTime = System.nanoTime();
        recursivePalindrome(input, 0, input.length() - 1);
        endTime = System.nanoTime();
        results.put("Recursive", endTime - startTime);

        // Stack
        startTime = System.nanoTime();
        stackPalindrome(input);
        endTime = System.nanoTime();
        results.put("Stack", endTime - startTime);

        // Deque
        startTime = System.nanoTime();
        dequePalindrome(input);
        endTime = System.nanoTime();
        results.put("Deque", endTime - startTime);

        System.out.println("\nExecution Time (in nanoseconds):");
        for (Map.Entry<String, Long> entry : results.entrySet()) {
            System.out.printf("%-10s : %d ns\n", entry.getKey(), entry.getValue());
        }

        scanner.close();
    }
}

import java.util.Scanner;
public class PalindromeCheckerApp {
        static class Node {
            char data;
            Node next;

            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        private Node head = null;

        public void add(char data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public boolean isPalindrome() {

            if (head == null || head.next == null) {
                return true;
            }

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node secondHalf = reverse(slow);
            Node firstHalf = head;

            Node tempSecond = secondHalf;
            while (tempSecond != null) {
                if (firstHalf.data != tempSecond.data) {
                    return false;
                }
                firstHalf = firstHalf.next;
                tempSecond = tempSecond.next;
            }

            return true;
        }

        private Node reverse(Node node) {
            Node prev = null;
            Node current = node;
            Node nextNode;

            while (current != null) {
                nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            return prev;
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            UseCase8PalindromeCheckerApp list = new UseCase8PalindromeCheckerApp();

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            for (int i = 0; i < input.length(); i++) {
                list.add(input.charAt(i));
            }

            if (list.isPalindrome()) {
                System.out.println("The given string is a Palindrome.");
            } else {
                System.out.println("The given string is NOT a Palindrome.");
            }

            scanner.close();
        }
    }


}

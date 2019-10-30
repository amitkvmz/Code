import java.util.Scanner;
import java.util.Stack;

public class PalindromeInLL {
    public static void main(String args[]) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        linkedList.insertNode(1);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(5);
        linkedList.insertNode(3);
        linkedList.insertNode(2);
        linkedList.insertNode(1);

        System.out.println("palindrome ? " + checkPalindrome(linkedList.head));

    }

    /**
     * Using a stack
     * 
     * @param head
     * @return
     */
    static boolean checkPalindrome(LinkedListNode head) {
        Stack<Integer> dataStack = new Stack<>();

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast.next != null) {
            dataStack.push(slow.data);

            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the middle term now.
        // dataStack has exactly same number as in linkedList
        while (dataStack.size() != 0) {
            slow = slow.next;
            if (dataStack.pop() != slow.data) {
                return false;
            }
        }
        return true;
    }
}
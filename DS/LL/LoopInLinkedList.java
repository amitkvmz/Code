import java.util.*;

public class LoopInLinkedList {
    static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int node) {
            this.data = node;
            this.next = null;
        }

    }

    static class SinglyLinkedList {
        LinkedListNode head;
        LinkedListNode tail;

        SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        void insertNode(int data) {
            LinkedListNode linkedListNode = new LinkedListNode(data);
            if (head == null) {
                head = linkedListNode;
                head.next = tail;
            } else {
                this.tail.next = linkedListNode;
            }
            this.tail = linkedListNode;
        }
    }

    static int i;

    static boolean detectLoop(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                System.out.println("Node: " + slow.data);
                return true;
            }
            i++;
        }
        return false;
    }

    static void createLoop(LinkedListNode linkedListNode, int data) {
        LinkedListNode head = linkedListNode;
        while (linkedListNode.next != null) {
            linkedListNode = linkedListNode.next;
        }
        while (head.next != null) {
            if (head.next.data == data) {
                linkedListNode.next = head;
                return;
            }
            head = head.next;
        }

    }

    public static void main(String args[]) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total input you want.");
        int input = sc.nextInt();
        System.out.println("Please enter...");
        for (int i = 0; i < input; i++) {
            int nodeData = sc.nextInt();
            linkedList.insertNode(nodeData);
        }
        createLoop(linkedList.head, 5);
        System.out.println("loop found: " + detectLoop(linkedList.head) + " ::  " + i);
        sc.close();
    }
}
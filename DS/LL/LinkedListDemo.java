import java.util.*;

public class LinkedListDemo {
    static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int data) {
            this.data = data;
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

        public void insertNode(int newNode) {

            LinkedListNode linkedListNode = new LinkedListNode(newNode);
            if (this.head == null) {
                this.head = linkedListNode;
            } else {
                this.tail.next = linkedListNode;
            }
            this.tail = linkedListNode;
        }
    }

    public static void printLinkedList(LinkedListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printLinkedList(head.next);
    }

    public static void deleteNode(LinkedListNode head, int key) {
        while (head.next.data != key && head != null) {
            head = head.next;
        }

        head.next = head.next.next;
    }

    public static void deleteNodeUsingRecursion(LinkedListNode head, int key) {

        if (head.next.data == key) {
            head.next = head.next.next;
            return;
        }
        deleteNodeUsingRecursion(head.next, key);

    }

    public static int middleOfLinkedList(LinkedListNode head) {
        LinkedListNode fast = head.next;
        LinkedListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public static int nodeFromLast(LinkedListNode node, int positionFromLast) {
        LinkedListNode fast = node;
        for (int i = 0; i < positionFromLast; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            node = node.next;
            fast = fast.next;
        }

        return node.data;
    }

    public static void main(String args[]) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        Scanner sc = new Scanner(System.in);
        int inputCount = sc.nextInt();
        for (int i = 0; i < inputCount; i++) {
            int nodeInput = sc.nextInt();
            linkedList.insertNode(nodeInput);
        }

        printLinkedList(linkedList.head);

        System.out.println("Which node to delete? ");
        int nodeToDelete = sc.nextInt();
        deleteNode(linkedList.head, nodeToDelete);
        printLinkedList(linkedList.head);

        printLinkedList(linkedList.head);

        System.out.println("Delete node using recursion.");
        nodeToDelete = sc.nextInt();
        deleteNodeUsingRecursion(linkedList.head, nodeToDelete);
        printLinkedList(linkedList.head);

        System.out.println("Get the middle of the resulting LinkedList " + middleOfLinkedList(linkedList.head));

        System.out.println("enter the position from last you want the value from ?");
        int positionFromLast = sc.nextInt();

        printLinkedList(linkedList.head);
        System.out.println("Node from last : "+nodeFromLast(linkedList.head, positionFromLast));
    }
}
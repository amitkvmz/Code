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

    /**
     * prints all the Linked List elements
     * 
     * @param head
     */
    public static void printLinkedList(LinkedListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        printLinkedList(head.next);
    }

    /**
     * Deletes the node from the Linked list using iteration
     * 
     * @param head
     * @param key
     */
    public static void deleteNode(LinkedListNode head, int key) {
        while (head.next.data != key && head != null) {
            head = head.next;
        }

        head.next = head.next.next;
    }

    /**
     * Deletes the Node from LinkedList using recursion
     * 
     * @param head
     * @param key
     */
    public static void deleteNodeUsingRecursion(LinkedListNode head, int key) {

        if (head.next.data == key) {
            head.next = head.next.next;
            return;
        }
        deleteNodeUsingRecursion(head.next, key);

    }

    /**
     * Delete a Linked List node at a given position
     * 
     * @param head
     * @param position
     */
    public static void deleteNodeAtAGivenPosition(LinkedListNode head, int position) {
        int i = 1;
        while (i < position - 1) {
            head = head.next;
            i++;
        }
        head.next = head.next.next;
        return;

    }

    /**
     * Delete a Linked List node at a give position using recursion
     * 
     * @param head
     * @param position
     */
    public static void deleteNodeAtAGivenPositionUsingRecursion(LinkedListNode head, int position) {
        if (position == 2) {
            head.next = head.next.next;
            return;
        }

        deleteNodeAtAGivenPositionUsingRecursion(head.next, --position);
    }

    /**
     * gets the middle node of Linked List
     * 
     * @param head
     * @return
     */
    public static int middleOfLinkedList(LinkedListNode head) {
        LinkedListNode fast = head.next;
        LinkedListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    /**
     * returns the node from last of the Linked List
     * 
     * @param head
     * @param positionFromLast
     * @return
     */
    public static int nodeFromLast(LinkedListNode head, int positionFromLast) {
        LinkedListNode fast = head;
        for (int i = 0; i < positionFromLast; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            head = head.next;
            fast = fast.next;
        }
        return head.data;
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
        System.out.println("Node from last : " + nodeFromLast(linkedList.head, positionFromLast));

        System.out.println("current List is: ");
        printLinkedList(linkedList.head);

        System.out.println(" type which position you want to delete from start?");
        int input = sc.nextInt();
        deleteNodeAtAGivenPosition(linkedList.head, input);

        System.out.println("current list is: ");
        printLinkedList(linkedList.head);

        System.out.println(" type which position you want to delete using recursion?");
        input = sc.nextInt();
        deleteNodeAtAGivenPositionUsingRecursion(linkedList.head, input);

        System.out.println("current list is: ");
        printLinkedList(linkedList.head);

        System.out.println("Please input one more LinkedList ");
        int count = sc.nextInt();
        SinglyLinkedList linkedList2 = new SinglyLinkedList();

        for (int i = 0; i < count; i++) {
            input = sc.nextInt();
            linkedList2.insertNode(input);
        }
        System.out.println("The two linkedLists are ");
        printLinkedList(linkedList.head);
        printLinkedList(linkedList2.head);

        LinkedListNode resultant = mergeLists(linkedList.head, linkedList2.head);
        System.out.println("The merged sortedLinked Lists are..");
        printLinkedList(resultant);

    }

    static LinkedListNode mergeLists(LinkedListNode head1, LinkedListNode head2) {
        if (head2.next == null) {
            head1.next = head2;
        }
        if (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                return mergeLists(head1.next, head2);
            } else {
                LinkedListNode temp = head1.next;
                head1.next = head2;
                head1.next.next = temp;
                return mergeLists(head1, head2.next);
            }
        }
        return null;
    }
}
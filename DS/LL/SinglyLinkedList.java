public class SinglyLinkedList {
    LinkedListNode head;
    LinkedListNode tail;

    SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    void insertNode(int data) {
        LinkedListNode node = new LinkedListNode(data);
        if (head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }
}
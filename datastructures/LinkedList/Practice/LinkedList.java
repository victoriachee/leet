package LinkedList.Practice;

/**
 * Java program representing a singly linked list with basic operations.
 */
public class LinkedList {

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    /**
     * Adds a new node to the end of the linked list.
     *
     * @param val The data value of the new node.
     */
    public void addNode(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Deletes a node with the specified data value from the linked list.
     *
     * @param data The data value to be deleted.
     */
    public void deleteNode(int val) {
        // Check if the linked list is empty
        if (head == null) {
            return; // If empty, there's nothing to delete, so return
        }

        // Check if the node to be deleted is the head node
        if (head.val == val) {
            head = head.next; // If so, move the head pointer to the next node (effectively deleting the current head)
            return; // Return as the deletion is complete
        }

        // If the node to be deleted is not the head node, search for it
        Node current = head; // Start traversing from the head node
        while (current.next != null && current.next.val != val) {
            current = current.next; // Move to the next node until the target node is found or end of list is reached
        }

        // Check if the target node was found
        if (current.next != null) {
            current.next = current.next.next; // If found, bypass the node to be deleted by connecting its previous node to its next node
        }
    }

    /**
     * Reverses the linked list.
     */
    public void reverseLinkedList() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    // Other utility methods can be added as needed

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);

        System.out.println("Original Linked List:");
        linkedList.printList();

        linkedList.reverseLinkedList();

        System.out.println("Reversed Linked List:");
        linkedList.printList();
    }

    /**
     * Prints the elements of the linked list.
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

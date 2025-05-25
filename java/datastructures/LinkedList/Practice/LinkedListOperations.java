package LinkedList.Practice;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListOperations {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }


    /**
     * Uses a HashSet to keep track of unique values encountered while traversing the linked list. 
     * If a duplicate is found, it removes the current node.
     *  
     * @param head Root node of linked list
     */
    public static void removeDuplicates(ListNode head) {
        if (head == null) {
            return;
        }

        HashSet<Integer> uniqueValues = new HashSet<>();
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            if (uniqueValues.contains(current.val)) {
                // Duplicate found, remove current node
                previous.next = current.next;
            } else {
                // Add current value to set
                uniqueValues.add(current.val);
                previous = current;
            }

            current = current.next;
        }
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example Usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        head = reverseList(head);

        System.out.println("Reversed List:");
        printList(head);

        removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}

package practice.FastSlowPointers;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    /**
     * The function `hasCycle` determines if a linked list has a cycle by using two pointers, one
     * moving at twice the speed of the other, and returns true if the pointers meet indicating a cycle,
     * otherwise false.
     * 
     * @param head The `head` parameter in the `hasCycle` method represents the starting point of a linked
     * list. It is a reference to the first node in the linked list. The method uses this parameter to
     * traverse the linked list and detect if there is a cycle within the list.
     * @return The method `hasCycle` returns a boolean value. It returns `true` if a cycle is detected in
     * the linked list starting from the given `head` node, and `false` if no cycle is found.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // list is empty or has 1 node
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // move pointer by 1 step
            fast = fast.next.next; // move pointer by 2 steps

            if (slow == fast) {
                return true; // pointers meet, cycle detected
            }
        }
        return false; // fast reached end of list, no cycle
    }
    
    // Main method to demonstrate the hasCycle method
    public static void main(String[] args) {
        LinkedListCycle cycleDetector = new LinkedListCycle();

        // Create nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        // Link nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Create a cycle here

        // Check for cycle
        boolean hasCycle = cycleDetector.hasCycle(node1);
        System.out.println("Cycle detected: " + hasCycle); // Should print: Cycle detected: true

        // Create a non-cyclic list for testing
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = null; // No cycle here

        // Check for cycle
        hasCycle = cycleDetector.hasCycle(nodeA);
        System.out.println("Cycle detected: " + hasCycle); // Should print: Cycle detected: false
    }
}


/* 
    Problem breakdown:
    1. Objective: Find out if there is a cycle in a linked list
    2. What is a cycle: A cycle in a linked list means you will eventually return to 
       the same node when traversing the linked list using the 'next' pointers.

    Edge cases:
    1. Head == null (list is empty) return false
    1. Head.next == null (list has 1 node) return false

    Approach:
    - Fast and slow pointers; slow moves 1 step, fast moves 2 steps
    - If there is no cycle, fast reaches the end (fast.next == null)
    - If there is a cycle, fast catches up to slow
 */

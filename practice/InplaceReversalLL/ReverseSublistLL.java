package practice.InplaceReversalLL;

public class ReverseSublistLL {


    /**
     * https://leetcode.com/problems/reverse-linked-list-ii/submissions/1328471016/
     * 
     * The function `reverseSublistLL` reverses a sublist within a linked list given the starting and
     * ending positions.
     * 
     * @param head The `head` parameter in the `reverseSublistLL` function represents the head node of
     * a singly linked list. This node serves as the starting point for traversing the linked list and
     * accessing its elements.
     * @param left The `left` parameter in the `reverseSublistLL` function represents the position of
     * the node where the sublist reversal should start. It indicates the index (1-based) of the node
     * in the linked list from where the reversal should begin.
     * @param right The `right` parameter in the `reverseSublistLL` function represents the index of
     * the rightmost node in the sublist that you want to reverse. This means that you want to reverse
     * the sublist starting from the `left` index up to the `right` index in the linked list.
     * @return The `reverseSublistLL` function returns the modified linked list after reversing the
     * sublist from position `left` to position `right`.
     */
    public static ListNode reverseSublistLL (ListNode head, int left, int right) {
        // pointer to before head node
        // pointer to traverse list to before left node
        ListNode pointer = new ListNode();
        pointer.next = head;
        ListNode beforeLeft = pointer;

        // beforeLeft -> 1 -> 2 -> 3 -> 4 -> 5 
        // if left is 2, int i = 1 accounts for 1 iteration to reach node b4 left
        for (int i = 1; i < left; i++) {
            beforeLeft = beforeLeft.next;  
        }

        ListNode curr = beforeLeft.next;
        ListNode next = curr.next;

        // reverse sublist from left to right
        for (int i = 0; i < right - left; i++) {
            // pointer -> 1 -> 2 -> 3 -> 4 -> 5
            //     beforeLeft curr next
            // 1. change curr.next to skip next node
            // 2. change next.next to before curr
            // 3. change beforeLeft.next to next
            // 4. change next node to curr.next   
            curr.next = next.next;
            next.next = beforeLeft.next;
            beforeLeft.next = next;
            next = curr.next;
        }
        // return modified list
        return pointer.next;
    }
    public static void main(String[] args) {
        // Create a linked list for testing: 1 -> 2 -> 3 -> 4 -> 5
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Reverse the sublist from position 2 to 4
        ListNode result = reverseSublistLL(node1, 2, 4);

        // Print the resulting list
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
}

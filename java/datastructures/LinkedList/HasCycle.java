/**
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 * To detect a cycle in a linked list, you can use Floyd's Tortoise and Hare algorithm.
 * This algorithm involves two pointers moving through the list at different speeds.
 * If there is a cycle, the two pointers will eventually meet.
 */

package LinkedList;

public class HasCycle {

   public static boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) return false;

      ListNode slow = head;
      ListNode fast = head.next.next;

      while (fast != null && fast.next != null) {
         if (slow == fast) return true;
         fast = fast.next.next; // ** must check fast.next != null
         slow = slow.next;
      }
      return false;
   }

   public static void main(String[] args) {
      // Example 1:
      ListNode head1 = new ListNode(3);
      head1.next = new ListNode(2);
      head1.next.next = new ListNode(0);
      head1.next.next.next = new ListNode(-4);
      head1.next.next.next.next = head1.next; // Creating a cycle

      System.out.println(hasCycle(head1)); // Output: true

      // Example 2:
      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);
      head2.next.next = head2; // Creating a cycle

      System.out.println(hasCycle(head2)); // Output: true

      // Example 3:
      ListNode head3 = new ListNode(1);

      System.out.println(hasCycle(head3)); // Output: false
   }
}

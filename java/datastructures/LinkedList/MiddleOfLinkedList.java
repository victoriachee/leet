/**
 * https://leetcode.com/problems/middle-of-the-linked-list
 */

package LinkedList;

public class MiddleOfLinkedList {

   public ListNode middleNode(ListNode head) {
      if (head == null || head.next == null) return head;

      ListNode slow = head, fast = head;

      // slow moves 1 step, fast moves 2 steps
      // If fast.next == null, there are 2 middle nodes & slow is the 2nd mid node
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }

      return slow;
   }

   // Prints out all node values for middle node
   public static void printList(ListNode head) {
      ListNode current = head;
      while (current != null) {
         System.out.print(current.val + " ");
         current = current.next;
      }
      System.out.println();
   }

   public static void main(String[] args) {
      // Example 1:
      ListNode head1 = new ListNode(1);
      head1.next = new ListNode(2);
      head1.next.next = new ListNode(3);
      head1.next.next.next = new ListNode(4);
      head1.next.next.next.next = new ListNode(5);

      MiddleOfLinkedList solution = new MiddleOfLinkedList();
      ListNode result1 = solution.middleNode(head1);

      System.out.println("Example 1:");
      System.out.println("Input: ");
      printList(head1);
      System.out.println("Output: ");
      printList(result1);
      System.out.println();

      // Example 2:
      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);
      head2.next.next = new ListNode(3);
      head2.next.next.next = new ListNode(4);
      head2.next.next.next.next = new ListNode(5);
      head2.next.next.next.next.next = new ListNode(6);

      ListNode result2 = solution.middleNode(head2);

      System.out.println("Example 2:");
      System.out.println("Input: ");
      printList(head2);
      System.out.println("Output: ");
      printList(result2);
   }
}

/**
 * https://leetcode.com/problems/remove-linked-list-elements
 */

package LinkedList;

public class RemoveElements {

   public static ListNode removeElements(ListNode head, int val) {
      // Handle case where head needs to be removed
      while (head != null && head.val == val) {
         head = head.next;
      }

      ListNode curr = head; // Pass by pointer

      while (curr != null && curr.next != null) {
         if (curr.next.val == val) {
            curr.next = curr.next.next;
         } else {
            curr = curr.next;
         }
      }

      return head;
   }

   public static void main(String[] args) {
      // Example 1:
      ListNode head1 = new ListNode(1);
      head1.next = new ListNode(2);
      head1.next.next = new ListNode(6);
      head1.next.next.next = new ListNode(3);
      head1.next.next.next.next = new ListNode(4);
      head1.next.next.next.next.next = new ListNode(5);
      head1.next.next.next.next.next.next = new ListNode(6);
      int val1 = 6;

      System.out.println("Example 1:");
      System.out.println("Val: \n" + val1);
      System.out.println("Input: ");
      printList(head1);
      ListNode result1 = removeElements(head1, val1);
      System.out.println("Output: ");
      printList(result1);
      System.out.println();

      // Example 2:
      ListNode head2 = null;
      int val2 = 1;

      System.out.println("Example 2:");
      System.out.println("Val:\n" + val2);
      System.out.println("Input: ");
      printList(head2);
      ListNode result2 = removeElements(head2, val2);
      System.out.println("Output: ");
      printList(result2);
      System.out.println();

      // Example 3:
      ListNode head3 = new ListNode(7);
      head3.next = new ListNode(7);
      head3.next.next = new ListNode(7);
      head3.next.next.next = new ListNode(7);
      int val3 = 7;

      System.out.println("Example 3:");
      System.out.println("Val:\n" + val3);
      System.out.println("Input: ");
      printList(head3);
      ListNode result3 = removeElements(head3, val3);
      System.out.println("Output: ");
      printList(result3);

      // Example 4:
      ListNode head4 = new ListNode(1);
      head4.next = new ListNode(2);
      head4.next.next = new ListNode(2);
      head4.next.next.next = new ListNode(1);
      int val4 = 2;

      System.out.println("Example 4:");
      System.out.println("Val:\n" + val4);
      System.out.println("Input: ");
      printList(head4);
      ListNode result4 = removeElements(head4, val4);
      System.out.println("Output: ");
      printList(result4);
   }

   // Helper method to print the linked list
   private static void printList(ListNode head) {
      while (head != null) {
         System.out.print(head.val + " ");
         head = head.next;
      }
      System.out.println();
   }
}
/* WRONG:
    while (curr != null && curr.next != null) {
            if (curr == head && curr.val == val) {
                head = curr.next;
            } else if (curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        if (head != null && head.val == val)
            head = head.next;

        return head; */

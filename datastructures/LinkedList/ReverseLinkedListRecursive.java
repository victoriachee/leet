/**
 * https://leetcode.com/problems/reverse-linked-list/
 */

package LinkedList;

public class ReverseLinkedListRecursive {

   public ListNode reverseList(ListNode head) {
      // Base case: If head is null, or head is last node in ll, return head
      if (head == null || head.next == null) return head;

      /**
       ** RECURSIVE CONCEPT for 2-node linked list reversal:
       * 2-node linked list:       head:[5]--->[6]--->null
       * newHead = head.next               ref:[6]--->null  //newHead is a pass-by ref
       * newHead.next = head            [5]<-->[6] ref
       * head.next = null       null<---[5]<---[6] ref
       */

      ListNode newHead = reverseList(head.next);
      head.next.next = head;
      head.next = null;

      return newHead;
   }

   public static void main(String[] args) {
      // Example 1:
      ListNode head1 = new ListNode(
         1,
         new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))
      );

      ReverseLinkedList solution = new ReverseLinkedList();

      System.out.println("Example 1:");
      System.out.println("Input: ");
      printList(head1);

      ListNode result1 = solution.reverseList(head1);

      System.out.println("Output: ");
      printList(result1);
      System.out.println();

      // Example 2:
      ListNode head2 = new ListNode(1, new ListNode(2));

      System.out.println("Example 2:");
      System.out.println("Input: ");
      printList(head2);

      ListNode result2 = solution.reverseList(head2);

      System.out.println("Output: ");
      printList(result2);

      // Example 3:
      ListNode head3 = null;

      System.out.println("Example 3:");
      System.out.println("Input: ");
      printList(head3);

      ListNode result3 = solution.reverseList(head3);

      System.out.println("Output: ");
      printList(result3);
   }

   public static void printList(ListNode head) {
      ListNode current = head;
      while (current != null) {
         System.out.print(current.val + " ");
         current = current.next;
      }
      System.out.println();
   }
}

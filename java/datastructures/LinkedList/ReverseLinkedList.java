/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * ! ITERATION (With diagram):
 * https://leetcode.com/problems/reverse-linked-list/solutions/2682085/java-0ms-100-easy-understanding/
 */

package LinkedList;

public class ReverseLinkedList {

   public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;

      while (curr != null) {
         ListNode next = curr.next; // ref to next
         curr.next = prev;
         prev = curr;
         curr = next;
      }

      return prev;
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

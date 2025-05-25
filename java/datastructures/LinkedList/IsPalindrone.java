/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */

package LinkedList;

public class IsPalindrone {

   public static boolean isPalindrome(ListNode head) {
      if (head == null) return false;
      if (head.next == null) return true; // [1] is a palindrome

      ListNode slow = head, fast = head;

      // 1. Find middle node
      // slow moves 1 step, fast moves 2 steps
      // If fast.next == null, there are 2 middle nodes &
      // slow is the 2nd mid node
      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }

      // 2. Reverse second half of LL using middle node
      slow = reverseList(slow);

      // 3. Compare first half of LL with second half of LL
      while (slow != null) {
         if (head.val != slow.val) return false;
         slow = slow.next;
         head = head.next;
      }

      return true;
   }

   public static ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;

      while (curr != null) {
         ListNode next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }

      return prev;
   }

   public static void main(String[] args) {
      // Example 1: [1, 2, 2, 1]
      ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
      System.out.println(isPalindrome(head1)); // Output: true

      // Example 2: [1, 2]
      ListNode head2 = new ListNode(1, new ListNode(2));
      System.out.println(isPalindrome(head2)); // Output: false

      // Example 3: [1]
      ListNode head3 = new ListNode(1);
      System.out.println(isPalindrome(head3)); // Output: true
   }
}

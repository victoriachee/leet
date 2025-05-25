package LinkedList;

public class DeleteDuplicates {

   public static ListNode deleteDuplicates(ListNode head) {
      
      // !Why make a new reference?
      // 1. To retain the head reference
      // 2. To use the new ref to traverse the linked list and modify it in-place by
      //    skipping duplicate nodes
      ListNode curr = head; // 'curr' is a new ref to the same obj 'head' is pointing to

      while (curr != null && curr.next != null) {
         if (curr.val == curr.next.val) {
            curr.next = curr.next.next;
         } else {
            curr = curr.next;
         }
      }
      return head;
   }

   // Main method for testing
   public static void main(String[] args) {
      // Example 1
      ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(4))));
      ListNode updatedList1 = deleteDuplicates(list1);
      printList(updatedList1); // Expected output: 1 2 4
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
/**
 * ListNode curr = head;: This line initializes a new reference curr to the same object
 * that head is pointing to. It's not a copy of the entire linked list; it's just another
 * reference pointing to the same nodes.
 *
 * else { curr = curr.next; }: If there is no duplicate, curr is moved to the next node
 * in the linked list. This is where the iteration continues.
 *
 *
 * return head;: The method returns the head of the linked list after duplicates
 * have been removed.
 *
 * curr is used to traverse the linked list and modify it in place by skipping
 * duplicate nodes. The head reference is retained, and the modified list is returned.
 * It's not creating a separate copy of the entire linked list; rather, it's using a
 * reference to traverse and modify the existing list.
 *
 */

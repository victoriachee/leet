package _HackerRank;

/**
 * Node class representing a node in a linked list.
 *
 * @param <T> The type of data stored in the node.
 */
class ListNode<T> {

    T data;
    ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Class to merge two sorted linked lists.
 *
 * @param <T> The type of data stored in the linked lists.
 */
public class D5Merge2SortedLinkedLists<T extends Comparable<T>> {

    /**
     * Merges two sorted linked lists into a new sorted linked list.
     *
     * @param head1 The head of the first sorted linked list.
     * @param head2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    public ListNode<T> mergeLists(ListNode<T> head1, ListNode<T> head2) {
        // Create a dummy node to simplify the code
        ListNode<T> dummy = new ListNode<>(null);
        ListNode<T> current = dummy;

        // Traverse both lists and merge
        while (head1 != null && head2 != null) {
            if (head1.data.compareTo(head2.data) <= 0) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        // If one of the lists is not fully traversed, append the remaining nodes
        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return dummy.next; // The merged list starts from the next of the dummy node
    }

    // Example usage
    public static void main(String[] args) {
        // Example linked lists
        ListNode<Integer> list1 = new ListNode<>(1);
        list1.next = new ListNode<>(3);
        list1.next.next = new ListNode<>(5);

        ListNode<Integer> list2 = new ListNode<>(2);
        list2.next = new ListNode<>(4);
        list2.next.next = new ListNode<>(6);

        // Merge the two lists
        D5Merge2SortedLinkedLists<Integer> merger = new D5Merge2SortedLinkedLists<>();
        ListNode<Integer> mergedList = merger.mergeLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.data + " ");
            mergedList = mergedList.next;
        }
        // Output: 1 2 3 4 5 6
    }
}

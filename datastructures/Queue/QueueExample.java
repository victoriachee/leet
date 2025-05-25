package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        // Create a queue
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(1); // Throws an exception if the queue is full
        queue.offer(2); // Returns false if the queue is full
        queue.add(3);
        queue.offer(4);

        // Display the queue
        System.out.println("Queue: " + queue);

        // Remove an element from the queue
        int removedElement = queue.remove(); // Throws an exception if the queue is empty
        System.out.println("Removed Element: " + removedElement);
        System.out.println("Queue after removal: " + queue);

        // Remove another element from the queue
        int polledElement = queue.poll(); // Returns null if the queue is empty
        System.out.println("Polled Element: " + polledElement);
        System.out.println("Queue after polling: " + queue);

        // Peek the element at the front of the queue
        int peekElement = queue.peek(); // Returns null if the queue is empty
        System.out.println("Peek Element: " + peekElement);
        System.out.println("Queue after peeking: " + queue);

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? " + isEmpty);

        // Get the size of the queue
        int size = queue.size();
        System.out.println("Size of the queue: " + size);

        // Clear the queue
        queue.clear();
        System.out.println("Queue after clearing: " + queue);

        // Try to peek and poll from an empty queue
        peekElement = queue.peek();
        polledElement = queue.poll();
        System.out.println("Peek Element from empty queue: " + peekElement);
        System.out.println("Polled Element from empty queue: " + polledElement);
    }
}

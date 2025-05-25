package Stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * A simple Java class representing a stack with useful functions and use cases.
 */
public class _StackOperations<T> {

    // Internal representation of the stack using Java's Stack class
    private Stack<T> stack;

    /**
     * Constructor to initialize the stack.
     */
    public _StackOperations() {
        stack = new Stack<>();
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param element The element to be pushed onto the stack.
     */
    public void push(T element) {
        stack.push(element);
    }

    /**
     * Removes an element from the bottom of the stack.
     */
    public void remove() {
        stack.remove(stack.size() - 1);
    }

    /**
     * Pops the element from top of the stack.
     *
     * @return The popped element.
     * @throws EmptyStackException if the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.pop();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Peeks at the top element of the stack without removing it.
     *
     * @return The top element of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    /**
     * Returns the size of the stack.
     *
     * @return The size of the stack.
     */
    public int size() {
        return stack.size();
    }

    /**
     * Prints the elements of the stack from top to bottom.
     */
    public void printStack() {
        System.out.print("Stack: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * *Example use case: Reversing a string using a stack.
     *
     * @param input The string to be reversed.
     * @return The reversed string.
     */
    public static String reverseString(String input) {
        _StackOperations<Character> charStack = new _StackOperations<>();

        // Push each character onto the stack
        for (char c : input.toCharArray()) {
            charStack.push(c);
        }

        // Pop characters from the stack to construct the reversed string
        StringBuilder reversedString = new StringBuilder();
        while (!charStack.isEmpty()) {
            reversedString.append(charStack.pop());
        }

        return reversedString.toString();
    }

    public static void main(String[] args) {
        // Example usage of the CustomStack class
        _StackOperations<Integer> intStack = new _StackOperations<>();

        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        intStack.printStack();

        System.out.println("Popped element: " + intStack.pop());

        intStack.printStack();

        System.out.println("Peeked element: " + intStack.peek());

        System.out.println("Is stack empty? " + intStack.isEmpty());

        System.out.println("Stack size: " + intStack.size());
    }
}

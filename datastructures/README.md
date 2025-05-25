# Java Data Structures Guide

This guide provides an overview of common Java data structures and when to use each one.

## Summary

- **Arrays**: Fixed-size, fast index access.
- **ArrayList**: Resizable, fast random access.
- **HashMap**: Key-value associations, fast operations.
- **HashSet**: Unique elements, fast operations.
- **TreeSet**: Sorted set, range operations.
- **LinkedList**: Fast insertions/deletions, queue or stack.
- **Matrix**: 2D data manipulation, mathematical operations.
- **Queue**: FIFO processing, BFS algorithms.
- **Stack**: LIFO processing, DFS algorithms.
- **Priority Queue**: Priority-based processing, optimal for tasks with varying importance.

## Arrays
- **Description**: 
    Fixed-size, contiguous memory allocation structures storing elements of the same type.
- **When to Use**:
  - Known and fixed number of elements.
  - Fast access to elements by index.
  - Memory efficiency is crucial.
- **Visual**:
  ```
    Index:  0   1   2   3   4
    Value: [a] [b] [c] [d] [e]
  ```


## ArrayList
- **Description**: 
    Resizable array implementation of the `List` interface.
- **When to Use**:
  - Dynamic resizing.
  - Fast random access to elements.
  - Order of elements is important.
- **Visual**:
  ```
    Index:  0   1   2   3   4
    Value: [a] [b] [c] [d] [e]
  ```


## HashMap
- **Description**: 
    Stores key-value pairs with constant-time performance for basic operations.
- **When to Use**:
  - Associating keys with values.
  - Fast lookups, inserts, and deletions.
- **Visual**:
  ```
    Key:   [1] [2] [3] [4] [5]
    Value: [a] [b] [c] [d] [e]
  ```


## HashSet
- **Description**: 
    Collection not allowing duplicate elements with constant-time performance.
- **When to Use**:
  - Storing unique elements.
  - Fast lookups and inserts without duplicates.
- **Visual**:
  ```
    Value: {a, b, c, d, e}
  ```


## TreeSet
- **Description**: 
    Sorted set implementing the `NavigableSet` interface backed by a `TreeMap`.
- **When to Use**:
  - Sorted set requirement.
  - Range operations on the set.
- **Visual**:
  ```
    Value: {a, b, c, d, e} (sorted)
  ```


## LinkedList
- **Description**: 
    Doubly-linked list implementation of the `List` and `Deque` interfaces.
- **When to Use**:
  - Fast insertions and deletions at both ends.
  - Implementing a queue or a stack.
- **Visual**:
  ```
    Head <-> [a] <-> [b] <-> [c] <-> [d] <-> [e] <-> Tail
  ```


## Matrix
- **Description**: 
    2D array representing a grid or table of elements.
- **When to Use**:
  - Representing and manipulating 2D data.
  - Performing mathematical operations on matrices.
- **Visual**:
  ```
    int[][] array = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

        Col 0  Col 1  Col 2
    Row 0  [a00] [a01] [a02]
    Row 1  [a10] [a11] [a12]
    Row 2  [a20] [a21] [a22]
  ```
    - Row Index: 
      The first index specifies the row. For example, array[1] refers to the 2nd row {4, 5, 6}.
    - Column Index: 
      The second index specifies the column within the selected row. For example, array[1][2] refers to the element 6 in the second row and third column.

## Queue
- **Description**: 
    Collection holding elements prior to processing, following the FIFO principle.
- **When to Use**:
  - Processing elements in the order they were added.
  - Implementing breadth-first search (BFS) algorithms.
- **Visual**:
  ```
    Front -> [a] -> [b] -> [c] -> [d] -> [e] -> Rear
  ```


## Stack
- **Description**: 
    Collection following the LIFO principle.
- **When to Use**:
  - Reversing elements or processing in reverse order.
  - Implementing depth-first search (DFS) algorithms.
- **Visual**:
  ```
    Top
      |
    [e]
    [d]
    [c]
    [b]
    [a]
      |
    Bottom
  ```


## Priority Queue
- **Description**: 
    Collection holding elements that maintains a priority for elements where the smallest element has the highest priority. Elements with higher priority are processed before those with lower priority. Element with the highest priority (the smallest element in the case of a min-heap) can be accessed in constant time, and insertion and deletion operations can be performed in logarithmic time.
- **When to Use**:
  - Managing tasks with different levels of importance.
  - Implementing algorithms like Dijkstra's or A* for shortest path finding.
  - Scheduling tasks in operating systems and simulations.
- **Visual**:
  ```
    Index:      0   1   2   3   4  
    Value:     [1,  2,  3,  4,  5]

         1 (root)
       /   \
     2       3 (children)
    / \     / \
   4   5   6   7
  ```


## Heap
- **Description**: 
  In Java, a heap is a special tree-based data structure. In Java, heaps are commonly implemented using the PriorityQueue class, which by default is a min-heap. Internally, it uses a binary heap, which is a complete binary tree, but it is represented as an array for efficiency

## Min-Heap
- **Description**:  
    In a min-heap, the key at the root must be the smallest among all keys present in the heap. The same property must be recursively true for all subtrees of the root.
- **Visual**: 
  ```
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
  ```


## Max-Heap
- **Description**:
    In a max-heap, the key at the root must be the largest among all keys present in the heap. The same property must be recursively true for all subtrees of the root.
    
  ```java 
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
  ```
- **Visual**:
  ```
          8
        /   \
       6     7
      / \   / \
     4   5 3   2 

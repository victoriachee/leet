# 14 Patterns

https://hackernoon.com/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed

## 1. Sliding Window
    Perform operation on a set window size of given DS.
- **When to Use**:
  - Given linear DS: array/LL/string
  - Given window size
  - Find subarray/longest or shortest substring/value


## 2. Two Pointers or Iterators
    Two pointers iterate through the DS until a condition is met.
- **When to Use**:
  - Given sorted array/LL
  - Find pair/triplet/subarray

- **Inefficient Solution**:
  - Brute force w. 1 pointer:  O(n²)


## 3. Fast and Slow pointers
    Two pointers iterate through the cyclic DS at different speeds, and fast pointer catches up to slow pointer when in a cyclic loop.
- **When to Use**:
  - Given loop/cycle in LL/array
  - Find position of elem or length of LL.


## 4. Merge Intervals
    Given intervals, find overlapping intervals or merge overlapping intervals. 6 cases of relation over time: 
    1. a and b do not overlap, 
    2. a and b overlap, b ends after a, 
    3. a fully overlaps b, 
    4. a and b overlap, a ends after b, 
    5. b fully overlaps a, 
    6. b and a do not overlap
- **When to Use**:
  - Given 'overlapping intervals'
  - Find list of mutually exclusive (non-overlapping) intervals


## 5. Cyclic sort O(n)
    Given array of numbers in a set range, iterates thru, and swaps numbers at wrong index with numbers at correct index.
- **When to Use**:
  - Given sorted array with numbers in a given range
  - Find missing/duplicate/smallest number in sorted/rotated array
  
- **Inefficient Solution**: O(n²)
  - Iterates array (for (int i = 0; i < n; i++))
  - check each elem if not in correct pos (while (arr[i] != i + 1)),
  - swap elem to correct pos (arr[i] with arr[correctIndex])
  - Can have multiple swaps for each elem 

- **Cyclic Sort**: O(n)
  - Single while loop (while (i < arr.length))
  - check each elem if not in correct pos (if (arr[i] != arr[correctIndex]))
  - swap elem to correct pos (arr[i] with arr[correctIndex])
  - if in correct pos, move to next elem (i++)
  - Minimal swaps


## 6. In-place reversal of linked list
    Given linked list, reverse links between nodes, constraint is using existing node objects/without using extra memory (done in-place)
- **When to Use**:
  - Given LL
  - Reverse LL without using extra memory/using existing nodes


## 7. Tree BFS
    Breadth First Search to traverse tree while using a queue to track all nodes of a level before moving to the next level.
- **When to Use**:
  - Traverse tree level-by-level (level-order traversal)
  
- **Tree BFS**: 
  - Push root node to queue, iterate until queue is empty.
  - At each iteration, remove node at head of queue, and visit node.
  - Insert all children of visited node into queue.


## 8. Tree DFS
    Depth First Search to traverse tree while using recursion (or stack for iterative approach) to track previous (parent) nodes. 
- **When to Use**:
  - Traverse tree w/ in-order (left, root, right), pre-order (root, left, right), or post-order (left, right, root) DFS
  - Search for thing in tree where desired node is closer to leaves (bottom nodes)
  
- **Tree DFS**: 
  - Starting at root/current node, 
  - decide when to process it (before, between, after recursive calls to children), 
  - recursively process children/subtrees.



## 9. Two heaps TODO
    Given set of elements that can be divided into 2 parts. Min Heap to find smallest elem, Max Heap to find biggest elem. Store 1st half in Max Heap, 2nd half in Min Heap. Median of current list is calculated from top elem of 2 heaps.
- **When to Use**:
  - Given Priority Queue/Scheduling (also useful for binary tree)
  - Find smallest/largest/median element of a set


## 10. Subsets
    BFS approach to solve problems involving permutations/combinations of a given set of elems.
    - A subset includes all possible combinations of elements from the input set, including the empty set and the set itself.
    - This method does not generate permutations (which are ordered arrangements of elements) but rather subsets (which are unordered combinations).
- **When to Use**:
  - Find permutations/combinations of a given set of elements
  
  **Subsets**:
  - Start the BFS with empty list to store subsets (list of lists),  result = [[]]
  - Initial subset is empty (Add empty list to reset)
  - For each elem in input set,create list to store new subsets, 
  - then iterate thru all existing subsets in result list. [[], [1]]
  - For each subset in result list, create a new subset and add elem to it, 
  - add new list to list of subsets [[], [1], [2], [1, 2]]
  - Add list of new subsets to result.
  - Repeat for all elems in the input set.
  - E.g. output which are subsets, showcasing BFS
      [] (empty subset)
      [1] (single element)
      [2] (single element)
      [3] (single element)
      [1, 2] (two elements)
      [1, 3] (two elements)
      [2, 3] (two elements)
      [1, 2, 3] (all elements)



## 11. Modified binary search
    Given sorted array/LL/matrix, and asked to find an elem, use Binary Search.
- **When to Use**:
  - Given sorted array/LL/matrix
  - Find an element
  **Modified binary search**:
  - Find middle of start & end (middle=start+(end—start)/2) (prevents integer overflow)
  - If 'key' = arr[middle], return middle as the required index
  - If 'key' < arr[middle], end = middle - 1
  - If 'key' > arr[middle], start = middle + 1


## 12. Top K elements TODO
    Given 
- **When to Use**:
  - Given LL
  - Reverse LL without using extra memory/using existing nodes


## 13. K-way Merge TODO
    Given 
- **When to Use**:
  - Given LL
  - Reverse LL without using extra memory/using existing nodes


## 14. Topological sort TODO
    Given 
- **When to Use**:
  - Given LL
  - Reverse LL without using extra memory/using existing nodes


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

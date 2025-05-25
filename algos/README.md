# Algorithmic Approaches

## Brute Force
- **Summary:** Simplest, exhaustively search all possible combinations
- **Identification:** Nested loops to consider all combinations
- **Wording:**
  - Find all pairs in array with given sum
  - Check all possible combinations
  - Enumerate all permutations {1,2,3} {1,3,2} {2,1,3} ...
- **Example:** Given int array, find pair with max sum

## Graph Algorithms
- **Summary:** Deal with graphs & their properties
- **Identification:** Nodes or edges, problems related to paths, connectivity, cycles, or traversals
- **Wording:** 
  - Find shortest path in a weighted graph from node A to node B
  - Detect cycles in a directed graph
- **Example:**
  - [x] Shortest Path in Weighted Graph: Node A to B in graph with weighted edges

## Tree Algorithms
- **Summary:** Hierarchical Structures like trees
- **Identification:** Binary tree, AVL trees, or other tree structures
- **Wording:**
  - Flatten a binary tree into a linked list.
  - Find the diameter of a binary tree.
  - Find height of a binary tree.
  - Check if a binary tree is balanced.
  - Check if two binary trees are identical.
- **Example:**
  - [x] Find lowest common ancestor in a binary tree

## Sorting Algorithms
- **Summary:** Order elements in a specific sequence
- **Identification:** Arranging data in ascending or descending order
- **Wording:** 
  - Sort an array of integers in non-decreasing order
  - Sort an array of intervals based on start or end points.
  - Find k smallest/largest elements in an array.
  - Sort an array of strings lexicographically.
  - Implement bubble sort.
  - Implement merge sort algorithm.
  - Apply quicksort algorithm.
  - Implement in-place merge sort.
  - Merge two sorted arrays into a single sorted array.
  - Sort an array with duplicate elements without extra space.
- **Example:**
  - [x] Find Kth Largest Element in an Array: Heap or QuickSelect

## Searching Algorithms
- **Summary:** Find location of a target element within a collection of items
- **Identification:** Locating a specific item in a dataset
- **Wording:**
  - Locate the index of a given value in a *sorted* array using binary search.
  - Search for an element in a 2D matrix.
  - Search for the majority element in an array.
  - Search for the first and last occurrence of an element in a sorted array.
  - Find the square root of a number using binary search.
- **Example:**
  - [] Binary Search: Find position of target in sorted array

## Hashing
- **Summary:** Use hash functions to map data to a fixed-size array for efficient retrieval
- **Identification:** Requires quick data look-up or frequency counting, faster than sorting for unordered input
- **Wording:**
  - Check if two binary trees are equal using hashing.
  - Detect a cycle in an undirected graph using hashing.
  - Group anagrams from a list of strings using a hash map.
  - Determine if there are duplicate elements within k distance in an array.
  - Find the first non-repeating character in a string using a hash map.
  - Find the longest substring without repeating characters using hashing.
  - Find the longest consecutive sequence in an unsorted array using hashing.
  - Find all pairs in an array that sum up to a specific target using hashing.
  - Count the number of subarrays with a given sum using a hash map.
- **Example:**
  - [] Two Sum: Given array, find two numbers for target sum

## String Matching Algorithms
- **Summary:** Locate the occurrence(s) of a substring in a string
- **Identification:** Finding patterns within text
- **Wording:**
  - Reverse a string in-place.
  - Check if a string is a palindrome.
  - Implement substring search.
  - Determine if two strings are anagrams.
  - Convert string to integer.
- **Wording:**
  - [x] Longest Common Substring: Within two strings

## Bit Manipulation
- **Summary:** Manipulate individual bits in binary representation
- **Identification:** Requires bitwise operations (AND, OR, XOR)
- **Wording:**
  - Find the single non-repeating element in an array.
  - Determine if a number is a power of two.
  - Find the maximum XOR of two numbers in an array.
  - Find the bitwise AND of a range of numbers.
- **Example:**
  - [] Single Number: Single non-repeating element in an array

## Backtracking
- **Summary:** Systematically explore all possibilities to find a solution
- **Identification:** Recursive structure with decisions made & undone to explore different paths
- **Wording:**
  - Find *all* possible permutations of a set
  - Explore *all* valid combinations of elements
  - Enumerate *all* paths in a maze
  - Generate *all* valid subsets of a set
  - Explore *all* paths in a graph to find a specific route
  - Enumerate *all* arrangements of characters in a string
- **Example:**
  - [x] Sudoku Solver: Fill 9×9 grid with digits from 1 to 9, with no repetition in rows, columns, and 3x3 subgrids
  - [x] N-Queens: Place N queens on an N×N chessboard so that no two queens threaten each other

## Greedy Algorithms
- **Summary:** Optimize locally at each stage hoping to find a global optimum
- **Identification:** Making best immediate choices at each step leads to optimal solution
- **Wording:**
  - Minimize the total cost by choosing the cheapest option at each step
  - Select the best immediate option
  - Choose the most promising option at each stage
- **Example:**
  - [x] Fractional Knapsack: Given weights & values of items, maximize total value in a knapsack of limited weight

## Dynamic Programming
- **Summary:** Break problem into smaller overlapping subproblems & solve each only once
- **Identification:**
  - Break problem into smaller overlapping subproblems
  - Solve each subproblem only once & store solutions to reuse
  - Optimal solution can be constructed from optimal solutions to subproblems
  - Repetitive patterns or subproblems
  - Optimization: Seek to maximize or minimize a certain value
  - Often used for finding best solution among many possible solutions
- **Wording:**
  - Find the shortest path.
  - Determine the minimum/maximum cost.
  - Calculate the nth Fibonacci number.
  - Calculate the edit distance.
  - Calculate the maximum sum of a subarray.
  - Determine the length of the longest common subsequence.
  - Calculate the minimum cost to reach a destination.
  - Solve the traveling salesman problem (TSP) with dynamic programming.

- **Top-down (Recursive with memoization):**
  - **Summary:** Recursive with memoization to avoid redundant computations
  - **Identification:** Recursive with memoization to avoid redundant computations
  - **Wording:**
    - Find the shortest path
    - Determine the minimum cost to reach a destination
    - Calculate the nth Fibonacci number
    - Calculate the edit distance between two strings
    - Find the longest increasing subarray in an array
  - **Example:**
    - [] Top-down: Longest Increasing Subsequence: Find longest subsequence such that elements are in strictly increasing order
    - [x] Edit Distance: Transform one string into another using the minimum number of operations (insertion, deletion, substitution)

- **Bottom-up (Tabulation):**
  - **Summary:** Iterative approach building solutions from smaller subproblems
  - **Identification:** Iterative approach building solutions from smaller subproblems
  - **Wording:**
    - Calculate the maximum sum of a subarray
    - Determine the length of the longest common subsequence
    - Calculate the minimum cost to reach a destination
  - **Example:**
    - [x] Bottom-up: 0/1 Knapsack Problem: Given weights and values of items, maximize the total value in a knapsack of limited weight

# Algorithmic paradigms

## Divide & Conquer
- **Summary:** Divide problem into smaller subproblems, solve them, then combine solutions
- **Identification:** Recursive structure with a divide step, conquer step, & combine step
- **Wording:**
  - Sort an array using a recursive divide-and-conquer approach
  - Find a target using a recursive divide-and-conquer approach
- **Example:**
  - [x] Merge Sort: Sort array using divide-and-conquer
  - [] Binary Search: Halve search space by comparing target with the middle element until finding the target or an empty space

## Intervals
- **Summary:** Commonly used to solve problems where consecutive elements or ranges need to be identified and processed.
- **Non-Sorted Intervals:**
    - Not initially sorted, but need to identify intervals or ranges based on conditions. 
    - In such cases, sorting may be a preprocessing step.
- **Non-Numeric Intervals:**
    - Time intervals, character sequences, or other ordered set.
- **Disjoint Intervals:**
    - Intervals can be disjoint, with gaps between them. 
    - Identifying & working with disjoint intervals in any order.
- **Interval Merging:**
    - Intervals need to be merged or processed without requiring an initial sort. 
    - Overlapping intervals.
- **Interval Intersection:**
    - Finding the intersection of intervals, & sorting may not be a prerequisite.
- **Wordings:**
    - Merge overlapping intervals in a collection.
    - Merge intervals in a sorted array or list.
    - Merge new intervals into an existing set of non-overlapping intervals.
    - Find the minimum number of intervals to remove to make the rest non-overlapping.
    - Determine if two intervals intersect.
    - Implement an algorithm for interval intersection.
    - Determine if a point is within any interval.
    - Find the maximum number of overlapping intervals at any given point.
    - Implement an algorithm to partition intervals into disjoint sets.
    - Find the largest gap between intervals.
    - Determine the smallest set of intervals that covers a given range.

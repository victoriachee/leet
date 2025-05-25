# Dynamic Programming
- Key strength: Ability to optimize solutions by avoiding redundant computations
- Break down a problem into smaller more manageable subproblems & reuse their solutions.
- If space complexity is a concern, use an iterative bottom-up approach -> controlled SC.


# Types of Dynamic Programming Approaches
1. Top-down (Memoization) (Recursive or iterative - memoization with recursion elimination)
    1. Start from top and break it down into smaller subproblems.
    2. Use a memoization table (array or hash table) to store solutions to the subproblems.
    3. Look up solutions to the same subproblems & avoid recomputing it multiple times. (↓ TC)
       Not looking up solutions again may save space (↓ SC), but lead to ↑ TC. (a trade-off)

2. Bottom-up (Tabulation) (Iterative)
    1. Start solving the problem from the smallest subproblems. 
    2. Build up the solutions to larger subproblems iteratively.
    3. Use a table to store solutions to subproblems, & each entry is computed based on previously computed entries in the table.

# Identification
1. Optimal Substructure:
    Optimal solution to the problem can be constructed from the optimal solutions of its subproblems.

2. Overlapping Subproblems:
    The problem can be broken down into smaller subproblems, & the same subproblems are solved multiple times.

# Examples
1. Fibonacci Sequence:
    []  Problem: Find the nth Fib number
        - Memoization: fib(n) where fib(n) = fib(n-1) + fib(n-2)
2. Longest Common Subsequence (LCS):
    []  Problem: Find the length of the LCS bwt 2 sequences.
        - Bottom-up: Construct a 2D table to find LCS length.
3. Knapsack Problem:
    [x] Problem: Given a set of items, each with a weight & value, find maximum value obtainable by selecting a subset of items with a total weight not exceeding a limit.
        - Bottom-up: Use a 2D table to compute max val for each subproblem.
4. Edit Distance:
    [x] Problem: Find the minimum number of operations (insert, delete, substitute) required to convert one string to another.
        - Bottom-up: Use a 2D table to compute the minimum edit distance.
5. Coin Change Problem:
    [x] Problem: Determine the number of ways to make change for a given amount using a set of count denominations.
        - Bottom-up: Use a table to compute the number of ways for each amount.

# Common Wordings
    - "Find the minimum/maximum..."
    - "Count the number of..."
    - "Determine the longest/shortest..."
    - "Find the optimal ..."
    - "Compute the minimum/maximum value..."

# Common I/O Constraints
    - Input: Size of problem (Number of elements, Array size)
    - Output: Solution to optimization (Max/min value, optimal sequence)
    - Constraints: On input values, TC & SC


# Types of Searching Algorithm Approaches

1. Linear Search (Sequential) 
    - Approach: Sequentially check each element in a list until a match is found.
    - Identification: Straightforward using a loop to iterate through elements.
    - Wording: 
        - Find the first occurrence/position of a given element in a list.

2. Binary Search 
    - Approach: Splits search space in half at each step by comparing target with middle element.
    - Identification: Requires a **sorted** list as input.
    - Wording: 
        - Determine if a specific element exists in a **sorted** array.
        - Find the next greatest value in a sorted array.
        - Find the position in a sorted array to replace the element with a target, where arr remains sorted.

3. Hashing
    - Approach: Uses a hash function to map keys to indices, allowing for efficient lookups.
    - Identification: Uses hash tables or dictionaries.
    - Example: Search for a value associated with a given key in a dictionary
    - Wording: 
        HashMap:
        [x] Find first non-repeating char in a string and return its index.
        [x] *Group anagrams: Given array of strings, group anagrams together.
        []  Two Sum: Given int arr, find two nums such that they add up to target.
        [x] Longest Substring Without Repeating Characters, given a string.
        
        HashSet:
        []  Contains Duplicate: Given int arr, determine if any duplicates exist.
        [x] Intersection of Arrays: Given 2 arrs, compute their intersection.
        [x] Happy Number: Given a positive determine if a num is 'happy'.
        [x] Valid Sudoku: Determine if a 9x9 sudoku board is valid.
 
# Time Complexity & Space Complexity

1. Linear Search (Sequential) 
    - TC: O(n) -> Linear TC, checks each element one by one, taking linear time in worst case.
    - SC: O(1) -> Constant SC, uses minimal additional space.

2. Binary Search
    - TC: O(log n) -> Logarithmic TC, efficiently reduces search space.
    - SC: O(1) -> Constant SC, doesn't need additional space proportional to input size.

3. Hashing
    - TC: O(1) -> Constant TC, in average case.
    - SC: O(n) -> Linear SC, in worst case may need additional space for collision handling.    

# Others:

4. Interpolation Search:
    - Approach: Calculates the probable position of the target value based on its relationship with the range of values.
    - Identification: Requires a uniformly distributed sorted array.
    - Example: Find the index of a specific element in a sorted array.
    - Wording: Locate the position of a given element in a uniformly distributed sorted array.

5. Exponential Search:
    - Approach: Combines binary search and linear search. It first identifies a range where the target element might be and then performs binary search in that range.
    - Identification: Requires a sorted list.
    - Example: Search for an element in an exponentially increasing list.
    - Wording: Find the position of an element in a sorted list using exponential search.

6. Fibonacci Search:
    - Approach: Divides the array into two parts that have sizes based on Fibonacci numbers.
    - Identification: Requires a sorted list.
    - Example: Locate the position of an element in a sorted array.
    - Wording: Search for an element in a sorted array using Fibonacci search.


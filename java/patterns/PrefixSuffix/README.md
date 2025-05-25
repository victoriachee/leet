## Prefix Sum:
- Efficiently calculates the sum of elements up to a specified index.
- Ideal for queries involving the left part of the array.
- Example: Sum of elements in range [left, right] where left < right.

## Suffix Sum:
- Efficiently calculates the sum of elements from a specified index to the end.
- Ideal for queries involving the right part of the array.
- Example: Sum of elements in range [left, right] where left > right.

## Both Prefix and Suffix Sum:
- In some scenarios, computing both prefix and suffix sum arrays is beneficial. 
- This allows efficient answers to queries for arbitrary ranges by combining prefix and suffix sums.

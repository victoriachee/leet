package algos.Search.Binary;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * !Important Context:
 * In Java, characters are represented as primitive data types (char), and their
 * Unicode values determine their lexicographical order
 *
 * !For strings use:
 * value.compareTo(target)  > 0 => value greater than target,
 * value.compareTo(target) == 0 => value equal to target,
 * value.compareTo(target)  < 0 => value less than target
 */

public class NextGreatestLetter {

   public static char nextGreatestLetter(char[] letters, char target) {
      int left = 0, right = letters.length - 1; // Get left and right index
      char greatest = letters[0];

      while (left < right) {
         int mid = left + (right - left) / 2; // Avoids overflow

         if (letters[mid] <= target) {
            // Char at mid index is smaller or equal to target
            left = mid + 1;
         } else {
            //  Char at mid index is larger than target
            greatest = letters[mid];
            right = mid;
         }
      }

      // *** In the case that left kept increasing from mid + 1 until left == right,
      // *** but BS has not tested letters[right], check if letters[right] > target
      if (letters[right] > target) 
         greatest = letters[right];

      return greatest;
   }

   public static void main(String[] args) {
      // Example 1:
      char[] letters1 = { 'c', 'f', 'j' };
      char target1 = 'a';
      System.out.println(nextGreatestLetter(letters1, target1)); // Output: 'c'

      // Example 2:
      char[] letters2 = { 'c', 'f', 'j' };
      char target4 = 'c';
      System.out.println(nextGreatestLetter(letters2, target4)); // Output: 'f'
      char target2 = 'g';
      System.out.println(nextGreatestLetter(letters2, target2)); // Output: 'j'

      // Example 3:
      char[] letters3 = { 'x', 'x', 'y', 'y' };
      char target3 = 'z';
      System.out.println(nextGreatestLetter(letters3, target3)); // Output: 'x'
   }
}

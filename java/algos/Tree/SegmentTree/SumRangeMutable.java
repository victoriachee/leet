/**
 * https://leetcode.com/problems/range-sum-query-mutable
 * 
 * !! MEDIUM
 * #SegmentTree
 */

package algos.Tree.SegmentTree;

public class SumRangeMutable {

   public SumRangeMutable(int[] nums) {
      //TODO: Segment tree
   }

   public void update(int index, int val) {}

   public int sumRange(int left, int right) {
      return 0;
   }

   /*
    !!TOO MUCH TIME TAKEN:
    int[] prefixSum; // Copy of nums obj
    int[] passByNums; // Pass by pointer ref to update nums obj in-place

    public SumRangeMutable(int[] nums) {
        passByNums = nums;
        updateSums();
    }

    public void updateSums() {
        prefixSum = Arrays.copyOf(passByNums, passByNums.length);
        for (int i = 1; i < passByNums.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        //
        //  nums =      [1, 2, 3, 4]
        //  index:       0  1  2  3
        //  prefixSum = [1, 3, 6, 10]
        //  For idx 2 to 3 inclusive, sum = prefixSum[3] (10) - prefixSum[1] (3)
        //
    }

    public void update(int index, int val) {
        passByNums[index] = val;
        updateSums();
    }

    public int sumRange(int left, int right) {
        System.out.println("Sum Array: " + Arrays.toString(prefixSum));
        if (left == 0)
            return prefixSum[right];
        return prefixSum[right] - prefixSum[left - 1];
    } */

   public static void main(String[] args) {
      int[] nums = { 1, 2, 3, 4 };

      SumRangeMutable numArray = new SumRangeMutable(nums);

      // Test the sumRange method
      int result1 = numArray.sumRange(2, 3);
      System.out.println("Sum from index 2 to 3: " + result1); // Output: 7

      int result2 = numArray.sumRange(1, 2);
      System.out.println("Sum from index 1 to 2: " + result2); // Output: 5

      numArray.update(2, 6);
      int result3 = numArray.sumRange(1, 2);
      System.out.println("Updated sum from index 1 to 2: " + result3); // Output: 8
   }
}

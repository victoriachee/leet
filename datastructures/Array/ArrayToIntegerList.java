package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayToIntegerList {

   // List to int array
   public static int[][] mutableList0(int[] nums) {
      List<int[]> rList = new ArrayList<>();
      rList.add(new int[]{1, 2});
      rList.add(new int[]{3, 4});
      rList.add(new int[]{5, 6});

      int[][] result = rList.toArray(new int[rList.size()][]); //rList.size() is rows
      return result;
   }
   /*
      result = new int[][]{
      {1, 2},
      {3, 4},
      {5, 6}
      }; 
   */

   // [ Mutable lists ]

   // TC: O(n), SC: O(n)
   public static List<Integer> mutableList1(int[] nums) {
      List<Integer> list = new ArrayList<>();
      for (int val : nums) list.add(Integer.valueOf(val));
      return list;
   }

   // TC: O(n), SC: O(n)
   public static List<Integer> mutableList2(int[] nums) {
      List<Integer> list = new ArrayList<>();
      IntStream.of(nums).forEach(list::add);
      return list;
   }

   // TC: O(n), SC: O(n)
   public static List<Integer> mutableList3(int[] nums) {
      return IntStream.of(nums).boxed().collect(Collectors.toList());
   }

   // TC: O(n), SC: O(n)
   public static List<Integer> mutableList4(int[] nums) {
      return Arrays.stream(nums).boxed().collect(Collectors.toList());
   }

   // TC: O(n), SC: O(n)
   public static List<Integer> mutableList5(int[] nums) {
      return Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
   }

   // TC: O(n), SC: O(n)
   public static List<Integer> mutableListUsingAsList(int[] nums) {
      return Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));
   }

   // [ Immutable lists ]

   // TC: O(1), SC: O(n)
   public static List<Integer> immutableList1() {
      return Arrays.asList(1, 2, 3, 4, 5);
   }

   // TC: O(n), SC: O(n)
   public static List<Integer> immutableList2(int[] nums) {
      return Arrays.stream(nums).boxed().collect(Collectors.toUnmodifiableList());
   }

   // TC: O(n), SC: O(n)
   public static List<Integer> immutableList3(int[] nums) {
      return IntStream.of(nums).boxed().collect(Collectors.toUnmodifiableList());
   }

   public static void main(String[] args) {
      int[] intArray = { 1, 2, 3, 4, 5 };

      // Displaying results
      System.out.println("Mutable List 1: " + mutableList1(intArray));
      System.out.println("Mutable List 2: " + mutableList2(intArray));
      System.out.println("Mutable List 3: " + mutableList3(intArray));
      System.out.println("Mutable List 4: " + mutableList4(intArray));
      System.out.println("Mutable List 5: " + mutableList5(intArray));
      System.out.println("Immutable List 1: " + immutableList1());
      System.out.println("Immutable List 2: " + immutableList2(intArray));
      System.out.println("Immutable List 3: " + immutableList3(intArray));
   }
}

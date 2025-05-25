/**
 * This class shows how to use HashSet to remove duplicates from a List and Int Array.
 */

package algos.Hash.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {

   /** Remove duplicates from an ArrayList **/
   public static List<Integer> removeDuplicatesFromList(List<Integer> nums) {
      HashSet<Integer> set = new HashSet<>(nums); // Convert to HashSet
      return new ArrayList<>(set); // Convert back to List
   }

   /** Remove duplicates from an int array **/
   public static int[] removeDuplicatesFromArray(int[] nums) {
      // Convert to HashSet (Unique by default)
      HashSet<Integer> set = new HashSet<>(); 
      for (int num : nums) set.add(num);

      // Convert HashSet back to int array
      int[] newArr = new int[set.size()];
      int i = 0;
      for (int elem : set) newArr[i++] = elem;

      return newArr;
   }

   public static void main(String[] args) {
      int[] array = { 3, 5, 2, 8, 5, 7, 2, 6, 8 };
      List<Integer> list = new ArrayList<>(Arrays.asList(3, 5, 2, 8, 5, 7, 2, 6, 8));

      int[] uniqueArray = removeDuplicatesFromArray(array);
      List<Integer> uniqueList = removeDuplicatesFromList(list);

      System.out.println("Unique elements from array:");
      for (int uniqueElement : uniqueArray) {
         System.out.print(uniqueElement + " ");
      }
      System.out.println();
      System.out.println("Unique elements from list:");
      for (int uniqueElement : uniqueList) {
         System.out.print(uniqueElement + " ");
      }
   }
}

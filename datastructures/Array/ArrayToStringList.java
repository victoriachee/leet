/**
 * This class contains methods to convert an array to a list, with options
 * for creating both mutable and immutable lists.
 */

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToStringList {

   public static void main(String[] args) {
      String[] arr = { "apple", "banana", "orange" };

      //* Mutable Lists:

      // 1. Using ArrayList constructor with Arrays.asList() (mutable)
      List<String> mutableList1 = new ArrayList<>(Arrays.asList(arr));

      // 2. Using for-each loop and Collections.addAll (mutable)
      List<String> mutableList2 = new ArrayList<>();
      Collections.addAll(mutableList2, arr);

      // 3. Using ArrayList addAll with Arrays.asList() (mutable)
      List<String> mutableList3 = new ArrayList<>();
      mutableList3.addAll(Arrays.asList(arr));

      // 4. Using Java 8 Arrays.asList() and ArrayList constructor (mutable)
      List<String> mutableList4 = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));

      List<String> list = new ArrayList<>();
      for (var val : arr) list.add(val);

      //* Immutable Lists:

      // 5. Using varargs for fixed-size immutable List
      List<String> immutableList1 = Arrays.asList("apple", "banana", "orange");

      // 6. Using Arrays.asList() for Arrays (fixed-size immutable List)
      List<String> immutableList2 = Arrays.asList(arr);

      // 7. Using Java 9+ List.of method (immutable)
      List<String> immutableList3 = List.of(arr);

      System.out.println("Mutable List 1: " + mutableList1);
      System.out.println("Mutable List 2: " + mutableList2);
      System.out.println("Mutable List 3: " + mutableList3);
      System.out.println("Mutable List 4: " + mutableList4);
      System.out.println("Immutable List 1: " + immutableList1);
      System.out.println("Immutable List 2: " + immutableList2);
      System.out.println("Immutable List 3: " + immutableList3);
   }
}

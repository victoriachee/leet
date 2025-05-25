package HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetOperations {

   // Method for Union, Intersection, and Difference of two sets
   public static void setOperations(Set<Integer> set1, Set<Integer> set2) {
      // Union: Combining elements from both sets without duplicates
      Set<Integer> union = new HashSet<>(set1);
      union.addAll(set2);

      // Intersection: Finding common elements between sets
      Set<Integer> intersection = new HashSet<>(set1);
      intersection.retainAll(set2);

      // Difference (set1 - set2): Elements that are present in set1 but not in set2
      Set<Integer> difference1 = new HashSet<>(set1);
      difference1.removeAll(set2);

      // Difference (set2 - set1): Elements that are present in set2 but not in set1
      Set<Integer> difference2 = new HashSet<>(set2);
      difference2.removeAll(set1);

      // Print results
      System.out.println("Set 1: " + set1);
      System.out.println("Set 2: " + set2);
      System.out.println("Union: " + union);
      System.out.println("Intersection: " + intersection);
      System.out.println("Difference (set1 - set2): " + difference1);
      System.out.println("Difference (set2 - set1): " + difference2);
   }

   // Additional HashSet Operations

   public static void addElements(Set<Integer> set, Integer... elements) {
      set.addAll(Arrays.asList(elements));
   }

   public static void removeElements(Set<Integer> set, Integer... elements) {
      set.removeAll(Arrays.asList(elements));
   }

   public static boolean isSetEmpty(Set<Integer> set) {
      return set.isEmpty();
   }

   public static int getSize(Set<Integer> set) {
      return set.size();
   }

   public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
      return set1.equals(set2);
   }

   public static boolean doesSetContainElement(Set<Integer> set, Integer element) {
      return set.contains(element);
   }

   public static void clearSet(Set<Integer> set) {
      set.clear();
   }

   // Main method
   public static void main(String[] args) {
      Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
      Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
      
      setOperations(set1, set2);

      // Additional HashSet Operations
      addElements(set1, 5, 6, 7);
      removeElements(set2, 6, 7);
      System.out.println("After adding elements to Set 1: " + set1);
      System.out.println("After removing elements from Set 2: " + set2);

      System.out.println("Is Set 1 empty? " + isSetEmpty(set1));
      System.out.println("Size of Set 2: " + getSize(set2));
      System.out.println("Are Set 1 and Set 2 equal? " + areSetsEqual(set1, set2));
      System.out.println("Does Set 1 contain 3? " + doesSetContainElement(set1, 3));

      clearSet(set1);
      System.out.println("Set 1 after clearing: " + set1);
   }
}

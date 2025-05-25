package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListOperations {

   // [ BASIC ]

   // 1. Is Empty
   public static boolean isListEmpty(List<?> list) {
      return list.isEmpty();
   }

   // 2. Contains
   public static boolean containsElement(List<Integer> list, int element) {
      return list.contains(element);
   }

   // 3. Index Of
   public static int findIndexOfElement(List<Integer> list, int element) {
      return list.indexOf(element);
   }

   // 4. Find Maximum
   public static int findMaxElement(List<Integer> list) {
      return Collections.max(list);
   }

   // [ SORT & REORDER ]

   // 5a. Sort list in ascending order
   public static void sortList(List<Integer> list) {
      Collections.sort(list);
   }

   // 5b. Sort the elements in descending order
   public static void sortListDesc(List<Integer> list) {
      Collections.sort(list, Collections.reverseOrder());
   }

   // 6. Reverse list
   public static void reverseList(List<Integer> list) {
      Collections.reverse(list);
   }

   // [ SUBSET MANIPULATION ]

   // 7. Create sublist from list
   public static List<Integer> createSubList(List<Integer> list, int fromIndex, int toIndex) {
      return list.subList(fromIndex, toIndex);
   }

   // 8. Remove subset from list
   public static List<Integer> removeSubList(List<Integer> list, List<Integer> subset) {
      list.removeAll(subset);
      return list;
   }

   // [ CONCATENATION ]

   // 9. Concatenate lists
   public static List<Integer> concatenateLists(List<Integer> list1, List<Integer> list2) {
      List<Integer> result = new ArrayList<>(list1);
      result.addAll(list2);
      return result;
   }

   // [ STREAM & FILTER ]

   // 10. Check All match
   public static boolean checkAllEven(List<Integer> list) {
      return list.stream().allMatch(num -> num % 2 == 0);
   }

   // 11. Remove elements by condition
   // a. Filter even numbers from the list (Collect even numbers)
   public static List<Integer> filterEvenNumbers(List<Integer> list) {
      return list.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
   }

   // b. Remove elements by value
   public static List<Integer> removeElementsByValue(List<Integer> list, int value) {
      return list.stream().filter(num -> num != value).collect(Collectors.toList());
   }

   // c. Remove duplicates (Collect distinct numbers)
   public static List<Integer> removeDuplicates(List<Integer> list) {
      return list.stream().distinct().collect(Collectors.toList());
   }

   // [ MATH OPERATIONS ]

   // 12. Calculate Sum
   public static int calculateSum(List<Integer> list) {
      return list.stream().mapToInt(Integer::intValue).sum();
   }

   // 13. Calculate Product
   public static long calculateProduct(List<Integer> list) {
      // (a, b) -> a * b  //accumulator function, which takes two parameters (the accumulated value and the current element)
      return list.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b); 
   }

   public static void main(String[] args) {
      List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 3, 1));
      System.out.println(numbers);

      //  1. Checking if the list is empty
      boolean isEmpty = isListEmpty(numbers);
      System.out.println("Is List Empty: " + isEmpty);

      // 2. Checking if a specific element is present in the list
      int targetElement = 8;
      boolean containsElement = containsElement(numbers, targetElement);
      System.out.println("Contains " + targetElement + ": " + containsElement);

      // 3. Finding the index of an element
      int indexOfElement = findIndexOfElement(numbers, targetElement);
      System.out.println("Index of " + targetElement + ": " + indexOfElement);

      // 4. Creating a sublist
      int fromIndex = 1;
      int toIndex = 4;
      List<Integer> subList = createSubList(numbers, fromIndex, toIndex);
      System.out.println("Sublist: " + subList);

      // 5. Removing a subset from the list
      List<Integer> listAfterSubsetRemoval = removeSubList(numbers, subList);
      System.out.println("List after removing subset: " + listAfterSubsetRemoval);

      // 6. Concatenating two lists
      List<Integer> additionalNumbers = List.of(10, 7, 4);
      numbers = concatenateLists(numbers, additionalNumbers);
      System.out.println("Concatenated List: " + numbers);

      // 7. Finding the maximum element
      int maxElement = findMaxElement(numbers);
      System.out.println("Maximum Element: " + maxElement);

      // 8. Sorting the list
      sortList(numbers);
      System.out.println("Sorted List: " + numbers);

      // 9. Reversing the list
      reverseList(numbers);
      System.out.println("Reversed List: " + numbers);

      // 10. Checking if all elements match a condition
      boolean allEven = checkAllEven(numbers);
      System.out.println("All Even: " + allEven);

      // 11a. Filtering the list for even numbers
      List<Integer> evenNumbers = filterEvenNumbers(numbers);
      System.out.println("Even Numbers: " + evenNumbers);

      // 11b. Removing elements by value
      int valueToRemove = 4;
      List<Integer> listAfterRemoval = removeElementsByValue(numbers, valueToRemove);
      System.out.println("List after removing " + valueToRemove + ": " + listAfterRemoval);

      // 11c. Removing duplicates from the list
      List<Integer> distinctNumbers = removeDuplicates(numbers);
      System.out.println("Distinct Numbers: " + distinctNumbers);

      // 12. Summing the elements in the list
      int sum = calculateSum(numbers);
      System.out.println("Sum of Elements: " + sum);

      // 13. Product of all elements in the list
      long product = calculateProduct(numbers);
      System.out.println("Product of Elements: " + product);
   }
}

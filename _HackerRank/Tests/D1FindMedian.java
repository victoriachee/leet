/*
 * Complete the 'findMedian' function below.
 *
 * The function is expected to return an INTEGER that is the median.
 * The function accepts unsorted INTEGER_ARRAY arr with an odd number of elements as parameter.

   #Sorting  #Math
 */
package _HackerRank.Tests;

import java.io.*;
import java.util.*;

class D1FindMedian {

   public static int findMedian(List<Integer> arr) {
      List<Integer> newList = new ArrayList<>(arr);
      Collections.sort(newList);
      int mid = arr.size() / 2;
      return newList.get(mid);
   }

   public static void main(String[] args) throws IOException {
      List<Integer> arr = new ArrayList<>();
      arr.add(0);
      arr.add(1);
      arr.add(2);
      arr.add(4);
      arr.add(6);
      arr.add(5);
      arr.add(3);
      int result = D1FindMedian.findMedian(arr); // ans: 3
      System.out.println(result);
   }
}

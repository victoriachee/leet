/**
 * Time conversion:
 *
 * Convert a given time in 12-hour AM/PM format to military (24-hour) time. The
 * function timeConversion takes a string 's' as input and returns the time in
 * 24-hour format. The input time is valid, and the function outputs the
 * converted time.
 *
 * Example:
 * Input: "07:05:45PM"
 * Output: "19:05:45"
 */
package _HackerRank;

import java.io.*;

public class D1TimeConversion {

  public static String timeConversion(String s) {
    int n = s.length();
    int hour12Format = Integer.parseInt(s.substring(0, 2)); // note that it is total length of 2
    char aOrP = s.charAt(n - 2);
    String endString = s.substring(2, n - 2);

    if (hour12Format == 12) { // 12PM / 12AM -> 00
      if (aOrP == 'A') hour12Format = 0;
    } else { // 7AM / 7PM -> 19
      if (aOrP == 'P') hour12Format += 12;
    }
    return String.format("%02d", hour12Format) + endString;
  }

  public static void main(String[] args) throws IOException {
    // Example test cases
    String[] testCases = {
      "07:05:45PM",
      "12:00:00AM",
      "12:30:15PM",
      "03:45:59AM",
    };

    for (String testCase : testCases) {
      String result = timeConversion(testCase);
      System.out.println("Original Time: " + testCase);
      System.out.println("Converted Time (24-hour format): " + result);
      System.out.println();
    }
  }
}

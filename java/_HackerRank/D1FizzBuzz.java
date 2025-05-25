/*
 * FizzBuzz:
 * Print numbers from 1 to n.
 * For multiples of 3, print "Fizz" instead of the number.
 * For multiples of 5, print "Buzz" instead of the number.
 * For numbers which are multiples of both three and five, print "FizzBuzz."

   #Modulus
 */

package _HackerRank;
import java.io.*;

public class D1FizzBuzz {

    public static void fizzBuzz(int n) {
        for (int i = 1; i<= n; i++) {
            // or i % 15
            if (i % 5 == 0 && i % 3 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Write number:");
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        D1FizzBuzz.fizzBuzz(n);

        bufferedReader.close();
    }
}


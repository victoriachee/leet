// #Recursion

package patterns.Recursion;

public class ComputeFactorial {

   public static void main(String[] args) {
      int n = 5;
      int result = factorial(n);
      System.out.println("Factorial of " + n + " is: " + result);
   }

   // Recursive function to calculate factorial
   public static int factorial(int n) {
      // Base case: factorial of 0 or 1 is 1
      if (n == 0 || n == 1) {
         return 1;
      } else {
         // Recursive case: n! = n * (n-1)!
         return n * factorial(n - 1);
      }
   }
}

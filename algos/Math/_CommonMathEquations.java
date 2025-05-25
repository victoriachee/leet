package algos.Math;

public class _CommonMathEquations {

   /**
    * Finds the highest divisor of a given number.
    * The function iterates through potential divisors from 2 up to half of the
    * given number and returns the highest divisor found.
    *
    * @param number The integer for which to find the highest divisor.
    * @return The highest divisor of the given number.
    */
   public static int findHighestDivisor(int number) {
      int highestDivisor = 1;

      for (int divisor = 2; divisor <= number / 2; divisor++) {
         if (number % divisor == 0) {
            highestDivisor = divisor;
         }
      }

      return highestDivisor;
   }

   /**
    * Calculates the sum of the first n natural numbers (1, 2,..., n) using the
    * formula n * (n + 1) / 2.
    *
    * @param n The number of natural numbers to sum.
    * @return The sum of the first n natural numbers.
    */
   public static int sumOfNaturalNumbers(int n) {
      return n * (n + 1) / 2;
   }

   /**
    * Calculates the midpoint between two integers using the formula left + (right - left) / 2.
    *
    * @param left  The left bound of the range.
    * @param right The right bound of the range.
    * @return The midpoint between left and right.
    */
   public static int calculateMidpoint(int left, int right) {
      return left + (right - left) / 2;
   }

   /**
    * Calculates the factorial of a non-negative integer.
    * n! = n × (n - 1) × (n - 2) × ... × 3 × 2 × 1
    * 3! = 3 × 2 × 1 = 6
    *
    * @param n The non-negative integer for which to calculate the factorial.
    * @return The factorial of n.
    */
   public static long factorial(int n) {
      if (n == 0 || n == 1) {
         return 1;
      } else {
         return n * factorial(n - 1);
      }
   }

   /**
    * Calculates the binomial coefficient, often denoted as "n choose k" or C(n, k), which represents
    * the number of ways to choose k items from a set of n distinct items without regard to the order
    * in which they are chosen.
    *
    * Used in various dynamic programming problems for calculating combinations, choosing elements
    * from a set, and solving certain recurrence relations.
    *
    * @param n The total number of distinct items.
    * @param k The number of items to choose.
    * @return The number of ways to choose k items from a set of n distinct items.
    */
   public static long calculateBinomialCoefficient(int n, int k) {
      if (k < 0 || k > n) {
         return 0;
      }
      return factorial(n) / (factorial(k) * factorial(n - k));
   }

   /**
    * Calculates the greatest common divisor (GCD) of two integers using Euclid's algorithm.
    * GCD(a, b) = GCD(b, a % b)   if b is not zero
    * GCD(a, b) = |a|             if b is zero
    * GCD(24, 36) = 12
    * a % b returns the remainder when a is divided by b.
    *
    * @param a The first integer.
    * @param b The second integer.
    * @return The GCD of a and b.
    */
   public static int gcd(int a, int b) {
      while (b != 0) {
         int temp = b;
         b = a % b;
         a = temp;
      }
      return Math.abs(a);
   }

   /**
    * Calculates the least common multiple (LCM) of two integers. It is the smallest positive
    * integer that is divisible by each of the given integers without leaving a remainder.
    * LCM(a, b) = |a * b| / GCD(a, b):
    * LCM(24, 36) = |24 * 36| / GCD(24, 36) = 72
    *
    * @param a The first integer.
    * @param b The second integer.
    * @return The LCM of a and b.
    */
   public static int lcm(int a, int b) {
      return Math.abs(a * b) / gcd(a, b);
   }

   /**
    * Calculates the arithmetic mean (average) of an array of values.
    *
    * @param values Array of numeric values.
    * @return Arithmetic mean of the values.
    */
   public static double calculateArithmeticMean(double[] values) {
      double sum = 0;
      for (double value : values) {
         sum += value;
      }
      return sum / values.length;
   }

   /**
    * Calculates the geometric mean of an array of positive values.
    *
    * @param values Array of positive numeric values.
    * @return Geometric mean of the values.
    */
   public static double calculateGeometricMean(double[] values) {
      double product = 1;
      for (double value : values) {
         product *= value;
      }
      return Math.pow(product, 1.0 / values.length);
   }

   /**
    * Calculates the standard deviation of an array of values.
    *
    * @param values Array of numeric values.
    * @return Standard deviation of the values.
    */
   public static double calculateStandardDeviation(double[] values) {
      double mean = calculateArithmeticMean(values);
      double sumSquaredDifferences = 0;
      for (double value : values) {
         sumSquaredDifferences += Math.pow(value - mean, 2);
      }
      return Math.sqrt(sumSquaredDifferences / values.length);
   }

   public static void main(String[] args) {
      // Example usage:
      int n = 5;
      System.out.println("Sum of first " + n + " natural numbers: " + sumOfNaturalNumbers(n));

      int left = 1;
      int right = 10;
      System.out.println(
         "Midpoint between " + left + " and " + right + ": " + calculateMidpoint(left, right)
      );
   }
}

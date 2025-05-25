/**
 * TowerBreakers represents a game where two players take turns reducing the height of n towers,
 * each initially of height m. A player can choose a tower's height x and reduce it to y,
 * where 1 < y < x and y evenly divides x.
 *
 * The towerBreakers function determines the game winner (1 for Player 1, 2 for Player 2).
 *
 * Example:
 * n = 2, m = 6
 * Towers: [6, 6]
 * Player 1 removes 3 pieces from a tower. Towers: [3, 6]
 * Player 2 matches the move. Towers: [3, 3]
 * Player 1 removes 2 pieces. Towers: [1, 3]
 * Player 2 matches again. Towers: [1, 1]
 * Player 1 has no move and loses. Returns 2.
 *
 * Constraints: 1 ≤ n, m ≤ 10^6
 *
 * Note: In specific cases (e.g., one tower of height 4), Player 1 chooses 1. Since
 * Player 2 has no move, Player 1 wins. The code is designed to handle such scenarios optimally.
 */
package _HackerRank;


public class D3TowerBreakers {

   /**
    * Determines the winner of the Tower Breakers game.
    *
    * @param n The number of towers.
    * @param m The height of each tower.
    * @return The winner of the game (1 for Player 1, 2 for Player 2).
    */
   public static int towerBreakers(int n, int m) {
      /**
       * !! Logic:
       * Returns 2 if n is even and/or m is 1, allowing P2 to mimic P1's moves and secure a win.
       * Returns 1 if n is odd and m is not 1, indicating that P2 cannot effectively copy P1's moves,
       * leading to P1 securing the win.
       */   
      return (n % 2 == 0 || m == 1) ? 2 : 1;

      // int[] towers = new int[n];
      // int player = 1; // Start with player 1
      // int numOfTowersLeft = n;
      // Arrays.fill(towers, m);

      // while (numOfTowersLeft > 0) {
      //     for (int i = 0; i < n; i++) {
      //         if (towers[i] > 1) {
      //             int y = findHighestDivisor(towers[i]);
      //             towers[i] = y;
      //             numOfTowersLeft--;

      //             if (numOfTowersLeft == 0) {
      //                 // No towers left, current player wins
      //                 return player;
      //             }

      //             player = (player % 2) + 1; // Alternate between players 1 and 2
      //         }
      //     }
      // }

      // return player; // If the loop ends, the last player wins
   }

   // Returns 1 or the highest divisor
   //    private static int findHighestDivisor(int x) {
   //       int highestDivisor = 1;

   //       for (int divisor = 2; divisor <= x / 2; divisor++) {
   //          if (x % divisor == 0) {
   //             highestDivisor = divisor;
   //          }
   //       }

   //       return highestDivisor;
   //    }

   public static void main(String[] args) {
      int n = 1, m = 4;
      System.out.println("n = " + n + " m = " + m + " winner = " + towerBreakers(n, m)); // 1
      n = 2;
      m = 2;
      System.out.println("n = " + n + " m = " + m + " winner = " + towerBreakers(n, m)); // 2
      n = 1;
      m = 7;
      System.out.println("n = " + n + " m = " + m + " winner = " + towerBreakers(n, m)); // 1
      n = 1;
      m = 3;
      System.out.println("n = " + n + " m = " + m + " winner = " + towerBreakers(n, m)); // 1
   }
}

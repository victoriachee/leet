/** 121. Best Time to Buy and Sell Stock
 * URL: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * ! EASY
 * #Greedy  #Arrays
 *
 * Given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize profit by choosing a day to buy and another to sell.
 * Return the maximum profit. If no profit, return 0.
 *
 * Example 1: Input: prices = [7,1,5,3,6,4] Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed (buy before sell).
 *
 * Example 2: Input: prices = [7,6,4,3,1] Output: 0
 * Explanation: No transactions done, max profit = 0.
 *
 * Constraints: 1 <= prices.length <= 10^5, 0 <= prices[i] <= 10^4
 */

package algos.Greedy;

public class BestTimeToBuySellStock {
   
   // more readable
   public int maxProfitV2(int[] prices) {
      int minPrice = prices[0];
      int maxProfit = 0;

      for (int i = 1; i < prices.length; i++) {
         int currentPrice = prices[i];
         int diff = currentPrice - minPrice;
         maxProfit = Math.max(maxProfit, diff);
         minPrice = Math.min(minPrice, currentPrice);
      }
      return maxProfit;
   }

   public int maxProfit(int[] prices) {
      int n = prices.length;
      if (n == 1) return 0;
      int maxProfit = 0;
      int minPrice = prices[0];

      for (int i = 1; i < n; i++) {
         if (minPrice < prices[i]) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
         }
         minPrice = Math.min(minPrice, prices[i]);
      }

      return maxProfit;
   }

   public static void main(String[] args) {
      BestTimeToBuySellStock solution = new BestTimeToBuySellStock();
      int[] prices1 = { 7, 1, 5, 3, 6, 4 };
      int[] prices2 = { 7, 6, 4, 3, 1 };

      System.out.println(solution.maxProfit(prices1)); // Output: 5
      System.out.println(solution.maxProfit(prices2)); // Output: 0

      System.out.println(solution.maxProfitV2(prices1)); // Output: 5
      System.out.println(solution.maxProfitV2(prices2)); // Output: 0
   }
}
/**
 * !Greedy approach:
 * Makes optimal decisions at each step without considering the entire array.
 * Identifies minimum buying price and updates maximum profit during iteration.
 * Prioritizes immediate gains, with the hope that they will fix the entire problem.
 * This method is greedy in nature as it aims to maximize the profit at each step,
 * expecting that the cumulative result will be the overall maximum profit.
 */

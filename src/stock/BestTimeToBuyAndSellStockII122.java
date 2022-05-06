package stock;
/**
 * 
 * 122. Best time to Buy and sell stock II
 * 
 * given an integer array prices where prices[i] is the price of a given stock on i th day.
 * 
 * you can only hold at most one share of the stock at any time.
 * you can buy it then immediately sell it on the same day.
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * 
 * 
 * Approach 3: Simple one pass
 * 
 * max profit : every profit obtain from every consecutive transition
 * 
 * we need not track the costs corresponding to the peaks and valleys along with the maximum profit,
 * we can directly keep on adding the difference between the consecutive number if the second number is larger than the first one.
 * 
 * for example:
 *  prices = [7,1,5,3,6,4]
 *  
 *  1 < 7
 *  5 > 1 // 5 - 1 = 4
 *  3 < 5
 *  6 > 3 // 6 - 3 = 3
 *  4 < 6
 *  
 *  output: 4 + 3 = 7
 *  
 *  
 *  
 *  
 * 
 *
 */

public class BestTimeToBuyAndSellStockII122 {
	
	public int maxProfit(int[] prices) {
		
		int max = 0;
		
		for(int i = 1; i < prices.length; i++) {
			// if the day is larger than the previous day
			if(prices[i] > prices[i - 1]) {
				max += prices[i] - prices[i - 1]; // subtract two number and add it to the max
			}
		}
		return max;
	}

}
/**
 * time: O(n). single pass.
 * space: O(1). constant space needed.
 */




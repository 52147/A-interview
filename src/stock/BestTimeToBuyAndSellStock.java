package stock;
/**
 * 
 * 121. Best time to Buy and sell stock
 * 
 *  
 * maximize profit by choosing a single day to buy one stock
 * and choosing a different in the future to sell the stock.
 * 
 * return the maximize profit
 * if you cannot return 0
 * 
 * 1. find a day to buy the stock and sell the stock(in the future day)
 * 2. for loop traverse a stock price array 
 *     - find and record the minimum price 
 *     - if the price is larger than minimum price
 *     - calculate the profit
 *     - and compare to the profit find before to find the larger profit
 * 3. return max profit
 *     
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Approach: One pass
 *
 */
public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int prices[]) {
		
		int minprice = Integer.MAX_VALUE; // hold the max value 2^31 - 1
		int maxprofit = 0;
		
		for(int i = 0; i < prices.length; i++) {
			// if we found the min price in the array, assign it to min 
			if(prices[i] < minprice) {
				minprice = prices[i];
			
			// otherwise count the price - min to get the max profit
			}else if(prices[i] - minprice > maxprofit) {
				maxprofit = prices[i] - minprice;
			}
		}
		
		return maxprofit;
	}

}
/**
 * time: O(n). only sing pass is needed.
 * space: O(1). only two variable are used.
 */



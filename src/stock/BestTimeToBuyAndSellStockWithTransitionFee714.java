package stock;
/**
 * 
 * You may complete as many transitions as you like,
 * but you need to pay the transition fee for each transition.
 * 
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * 
 * Approach : dp
 * 
 * cash: 
 * at the end of i day, we maintain cash,
 * the maximum profit we could have if we did not have a share stock
 * 
 * hold: the maximum profit we could have if we owned a share of stock
 * 
 * the transition from the i-th day to the i+1-th day,
 * we either sell our stock 
 * cash = max(cash, hold + prices[i] - fee) or
 * hold = max(hold, cash - prices[i])
 * 
 * 
 * At the end,
 * we want to return cash 
 * we can transform cash first without using temporary variables
 * because selling and buying on the same day can't be better than just continuing to hold the stock.
 * 
 *
 */
public class BestTimeToBuyAndSellStockWithTransitionFee714 {
	
	public int maxProfit(int[] prices, int fee) {
		
		int cash = 0; // sell the stock
		int hold =-prices[0]; // buy the stock
		
		for(int i = 1; i < prices.length; i++) {
			cash = Math.max(cash, hold + prices[i] - fee);
			// If I am not holding a share after today, then either I did not hold a share yesterday, 
			// or that I held a share yesterday but I decided to sell it out today
			hold = Math.max(hold, cash - prices[i]); // hold: the cash you have when hold a share
			//If I am holding a share after today, then either I am just continuing holding the share I had yesterday, 
			// or that I held no share yesterday, but bought in one share today: 
		}
		
		return cash;
	}

}
/**
 * time: O(N), where N is the number of prices
 * space: O(1), the space used by cash and hold.
 */





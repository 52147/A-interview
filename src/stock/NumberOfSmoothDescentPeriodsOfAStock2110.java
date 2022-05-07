package stock;
/**
 * 
 * 2110. Number of Smooth Descent Periods of a Stock
 * 
 * a smooth descent period
 * the price on each day is lower than the price on the preceding day by exactly 1
 * 
 * the first day of the period is exempted from this rule.
 * 
 * Input: prices = [3,2,1,4]
 * Output: 7
 * Explanation: There are 7 smooth descent periods:
 * [3], [2], [1], [4], [3,2], [2,1], and [3,2,1]
 * Note that a period with one day is a smooth descent period by the definition.
 * 
 * 
 * Approach: dp
 * 
 * if prices[i]== prices[i - 1] then dp[i] = dp[i - 1] + 1 else dp[i] = 1
 * 
 * for example: prices = [3, 2, 1, 4]
 * dp[0] = 1, [3] is a smooth descent period
 * dp[1] = 2, because 2 == 3 - 1, that is [2], [3, 2] are smooth descent periods
 * dp[2] = 3, because 1 == 2 - 1, that is [1], [2, 1], [3, 2, 1]are smooth descent periods
 * dp[3] = 1, because 4 != 1 - 0, that is only [4] is a smooth descent period
 * Note that the end of smooth descent periods are all marked in bold.
 * so the return value is sum(dp) = 7, because the answer needs the total count of smooth descent periods ended at any index of prices.
 *
 */
public class NumberOfSmoothDescentPeriodsOfAStock2110 {
	
	public long getDescentPeriods(int[] prices) {
		
		// use long not int
		long dp = 1; // base case dp[0] = 1
		long ans = 1;
		// for loop start at index 1 because index is base case dp[0] = 1 prices[0] = 1
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] == prices[i - 1] - 1 ) {
				dp++; // dp[i] = dp[i - 1] + 1;
			}else {
				dp = 1; //dp[i] = 1;
			}
			
			ans += dp; // ans += dp[i];
		}
		return ans;
	}

}
/**
 * space: O(1)
 * since dp[i] is only dependent on dp[i - 1], 
 * the Space Complexity can be reduced to O(1),
 *  and we can redefine dp as the number of smooth descent periods ended at the previous index
 */




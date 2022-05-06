package stock;
/**
 * 
 * 309. Best time to buy ans sell stock with cooldown
 * 
 *  find the maximum profit
 *  you may complete as many transitions as you like
 *  
 *  After you sell stock, you can not buy stock on the next day(cooldown one day)
 * 
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 
 * Approach : dp with state machine
 * 
 * three machine has 3 state:
 * 1. state held: sell action -> transition to the sold state
 * 
 * 2. state sold: buy action -> transition to the held state
 * 
 * 3. state reset: 
 *    - the transient state before the held and sold.
 *    - due to the cooldown rule, after the sold state, the agent can not immediately acquire any stock.
 *      is forced into the reset state.
 *  
 *       
 * algorithm:
 * 
 * 1. implement 3 state machine (held[i], sold[i], reset[i])
 * 
 *   elements in each array represents the maximal profits that we could gain 
 *   at the specific price point i with the specific state
 *   
 *   
 *   sold[2] => the maximal profits we gain if we sell the stock at the price point price[2]
 *
 *
 *  formula :
 *  
 *  sold[i] = hold[i - 1] + price[i]
 *  held[i] = max(held[i - 1], reset[i - 1] - price[i])
 *  reset[i] = max(reset[i - 1], sold[i - 1])
 *  
 *  Here is how we interpret each formulas:
 *
 * sold[i]: 
 *  - the previous state of sold can only be held. 
 *  - Therefore, the maximal profits of this state is the maximal profits of the previous state plus the revenue by selling the stock at the current price.
 *
 * held[i]: 
 *  - the previous state of held could also be held, 
 *     i.e. one does no transaction. 
 *  - Or its previous state could be reset, from which state, one can acquire a stock at the current price point.
 *
 * reset[i]: 
 *  - the previous state of reset could either be reset or sold. 
 *  - Both transitions do not involve any transaction with the stock.
 *  
 *  
 *  
 *  the result will be max(sold[n], reset[n])
 *  the maximal profits that we can gain from this game
 *   - at the last price point, either we sell the stock or we do not transition.
 *   - it makes no sense to acquire the stock at the last price point, which only leads to the reduction profits.
 *
 */
public class BestTimeToBuyAndSellStockWithCooldown {
	
	public int maxProfit(int[] prices) {
		
		int sold = Integer.MIN_VALUE;
		int held = Integer.MIN_VALUE;
		int reset = 0;
		
		for(int price: prices) {
			int preSold = sold; // the previous state of sold can only be held.
			
			sold = held + price; //  the maximal profits of this state is the maximal profits of the previous state plus the revenue by selling the stock at the current price.
			
			held = Math.max(held, reset - price);
			// held: the previous state of held could also be held, i.e. one does no transaction. 
			// reset - price:Or its previous state could be reset, from which state, one can acquire a stock at the current price point.
			
			reset = Math.max(reset, preSold); //the previous state of reset could either be reset or sold. Both transitions do not involve any transaction with the stock.
		}
		return Math.max(sold, reset);
		// at the last price point, either we sell the stock or we simply do no transaction, to have the maximal profits. 
		// It makes no sense to acquire the stock at the last price point, 
		// which only leads to the reduction of profits.
	}

}
/**
 * time: O(N) where N is the length of the input price list
 * space: O(1) constant memory is used regardless the size of the input
 */





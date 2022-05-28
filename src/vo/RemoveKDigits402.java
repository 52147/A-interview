package vo;

import java.util.LinkedList;

/**
 * 
 * 402. Remove K Digits
 * 
 * Given String num representing a non-negative integer num,
 * and an integer k,
 * return the smallest possible integer after removing k digits from num.
 * 
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * 
 * Approach : Greedy with Stack
 * 
 * Algorithm:
 * 
 * 
 * - Believe it or not, the above rule is the only key needed to solve the problem. 
 * - It clearly defines a condition on which we can remove a digit without a doubt. 
 * - By removing the digits one by one, we are steadily approaching the optimal solution step by step. 
 * - Now, it might ring a bell, to one of the popular algorithmic paradigms -− Greedy.
 * 
 * - the problem could be solved with the greedy algorithm. 
 * - The above rule clarifies the essential logic on how we can approach the final solution. 
 * - Once we remove a digit from the sequence, 
 * - the remaining digits forms a new problem where we can continue to apply the rule.
 * 
 * - One might notice that, 
 * - there could be some cases where the condition to apply the rule does not hold for any of the digits. 
 * - To put it in another word, in those cases, we would have a monotonic increasing sequence, i.e. each digit is bigger than its previous digit. 
 * - In this scenario, we simply remove the pending large digits, again, greedily. 
 * - We skip the rigorous proof here, and claim that the solution obtained by the above measure is indeed the optimal one.
 * 
 * 
 * Implementation
 * 
 * - One could implement the above algorithm with the help of the stack data structure. We use a stack to hold the digits that we would keep at the end.
 * 
 * - Iterating the sequence of digits from left to right, the main loop can be broken down as follows:
 * 
 * - 1). for each digit, if the digit is less than the top of the stack, i.e. the left neighbor of the digit, then we pop the stack, i.e. removing the left neighbor. At the end, we push the digit to the stack.
 * - 2). we repeat the above step (1) until any of the conditions does not hold any more, e.g. the stack is empty (no more digits left). or in another case, we have already removed k digits, therefore mission accomplished.
 * 
 * - We demonstrate how the algorithm works in the above graph. Given the input sequence [1, 2, 3, 4, 5, 2, 6, 4] and the number of digits to remove k=4, the rule is triggered for the first time at the digit of 5. Once we remove the digit 5, the rule is triggered again at the digit 4 till the digit 3. And then later, at the digit 6, the rule is triggered as well.
 * 
 * - Out of the above main loop, we need to handle some corner cases to make the solution more complete.
 * 
 * - case 1). when we get out of the main loop, we removed m digits, which is less than asked, i.e.(m < k). In the extreme case, we would not remove any digit for the monotonic increasing sequence in the loop, i.e. m==0. In this case, we just need to remove the additional k-m digits from the tail of the sequence.
 * - case 2). once we remove all the k digits from the sequence, there could be some leading zeros left. To format the final number, we need to strip off those leading zeros.
 * - case 3). we might end up removing all numbers from the sequence. In this case, we should return zero, instead of empty string.
 * 
 * Here are some sample implementations.
 * 
 */
public class RemoveKDigits402 {
	  public String removeKdigits(String num, int k) {
		    LinkedList<Character> stack = new LinkedList<Character>();
		        
		    for(char digit : num.toCharArray()) {
		      while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
		        stack.removeLast();
		        k -= 1;
		      }
		      stack.addLast(digit);
		    }    
		        
		    /* remove the remaining digits from the tail. */
		    for(int i=0; i<k; ++i) {
		      stack.removeLast();
		    }
		        
		    // build the final string, while removing the leading zeros.
		    StringBuilder ret = new StringBuilder();
		    boolean leadingZero = true;
		    for(char digit: stack) {
		      if(leadingZero && digit == '0') continue;
		      leadingZero = false;
		      ret.append(digit);
		    }
		        
		    /* return the final string  */
		    if (ret.length() == 0) return "0";
		    return ret.toString();
		  }

}
/**
 * Complexity Analysis
 *
 * - Time complexity : O(N). 
 * - Although there are nested loops, the inner loop is bounded to be run at most k times globally. 
 * - Together with the outer loop, we have the exact (N+k) number of operations. 
 * - Since 0<k≤N, the time complexity of the main loop is bounded within 2N. 
 * - For the logic outside the main loop, it is clear to see that their time complexity is O(N). 
 * - As a result, the overall time complexity of the algorithm is O(N).
 *
 * - Space complexity : O(N). 
 * - We have a stack which would hold all the input digits in the worst case.
 */







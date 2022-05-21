package vo;
/**
 * 55. Jump Game
 * 
 * - You are given an integer array nums.
 * - You are initially positioned at the array's first index,
 *   and each element in the array represents your maximum jump length at that position.
 *   
 * - Return true if you can reach the last index, or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * 
 * 
 * Approach : DP bottom up
 * 
 * - Top-down to bottom-up conversion is done by eliminating recursion.
 * - In practice, this achieves better performance as we no longer have the method stack overhead
 *   and might even benefit from some caching.
 *   
 * - More importantly, this step opens up possibilities for future optimization.
 * - The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.
 * 
 * - The observation to make here is that we only ever jump to the right.
 * - This means that if we start from the right of the array, every time we will query a position to our right,
 *   that position has already be determined as being Good or bad.
 *   
 * - This means we don't need to recurse anymore, as we will always hit the memo table.
 * 
 * 
 *
 */
enum Index{
	GOOD, BAD, UNKNOWN
}

public class JumpGame55 {
	
	public boolean canJump(int[] nums) {
		Index[] memo = new Index[nums.length];
		
		for(int i = 0; i < memo.length; i++) {
			memo[i] =  Index.UNKNOWN;
		}
		
		memo[memo.length - 1] = Index.GOOD;
		
		for(int i = nums.length - 2; i >= 0; i--) {
			int furthestJump = Math.min(i + nums[i], nums.length - 1);
			
			for(int j = i + 1; j <= furthestJump; j++) {
				if(memo[j] == Index.GOOD) {
					memo[i] = Index.GOOD;
					break;
				}
			}
			
		}
		
		
		return memo[0] == Index.GOOD;
		
	}

}

/**
 * time: O(n^2)
 * - For every element in the array, say i,
 *   we are looking at the next nums[i] elements to its right aiming to find a GOOD index.
 * - nums[i] can be at most n, where n is the length of array nums.
 * 
 * space: O(n)
 * - This comes from the usage of the memo table.
 * 
 */

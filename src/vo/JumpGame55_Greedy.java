package vo;
/**
 * 
 * Approach: Greedy
 * 
 * - Once we have our code in the bottom-up state,
 *   we can make one final, important observation.
 *   
 * - From a given position, when we try to see if we can jump to a GOOD position,
 *   we only ever use one - the first one(see the break statement).
 * - In other words, the left-most one.
 * - If we keep track of this left-most GOOD position as a separate variable,
 *   we can avoid searching for it in the array.
 * - Not only that, but we can stop using the array together.
 * 
 * 
 * - Iterating right-to left, for each position we check if there is a potential jump that reaches a GOOD index
 *   (currPosition + nums[currPosition] >= leftmostGoodIndex.)
 * - If we can reach a GOOD index, then our position is itself GOOD.
 * - Also, this new GOOD position will be the new leftmost GOOD index.
 * - Iteration continues until the beginning of the array.
 * - If the first position is a good index then we can reach the last index from the first postioion.
 *   
 * - To illustrate this scenario,
 *   we will use the diagram below, 
 *   for input array nums = [9, 4, 2, 1, 0, 2, 0].
 * - We write G for GOOD, B for BAD and U for UNKNOWN.
 * - Let's assume we have iterated all the way to position 0 and we need to decide if index 0 is GOOD.
 * 
 * - Since index 1 was determined to be GOOD, it is enough to jump there and then be sure we can eventually reach index 6.
 * - It does not matter that nums[0] is big enough to jump all the way to the last index. 
 * - All we need is one way.
 * 
 *
 */

// greedy approach:
// iterate right to left
// we check if there is a potential jump that reaches a GOOD index
// (currPosition + nums[currPosition] >= leftmostGoodIndex)
// if we cah reach a good index, then position is good.
// iterate continues until the beginning of the array.
// If first position is a good index then we can reach the last index from the first position.

// set a parameter as the nums length to represent the length that need to reach the last index
// use a for loop to traverse the nums array from the last index
// if the sum of i(the length from the first index) and nums[i](the length can jump) >= last position
//    set the last position to i (means if we can reach this i(position) we can reach the end)
// for loop end
// if last position is equal to 0 is true
// is means we can get to the end successfully from the first index



public class JumpGame55_Greedy {
	
	public boolean canJump(int[] nums) {
		
		int lastPos = nums.length - 1;
		
		for(int i = nums.length - 1; i >= 0; i--) {
			if(i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		
		return lastPos == 0;
	}

}

/**
 * 
 * time: O(n)
 * - we are doing a single pass through the nums array,
 *   hence n steps, where n is the length of array nums.
 *   
 * space: O(1)
 * - We are not using any extra memory.
 * 
 */


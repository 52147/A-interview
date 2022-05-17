package vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 78 Subsets
 * 
 * given an integer array nums of unique elements,
 * return all possible subsets(the power set).
 * 
 * the solution set must not contain duplicate subsets.
 * return the solution in any order.
 * 
 * Example 1:
 *
 *Input: nums = [1,2,3]
 *Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *Example 2:
 *
 *Input: nums = [0]
 *Output: [[],[0]]
 * 
 * 
 * 
 * Approach: backtracking
 * 
 * backtracking:
 * - an algorithm for finding all solutions by exploring all potential candidates.
 * - if the solution candidate turns to be not a solution(or not the last one),
 *   backtracking discards it by making some changes on the previous step,
 *   i.e. backtracks and then try again.
 * 
 * Algorithm:
 * 
 * we define a backtrack function named backtrack(first, curr)
 * which takes the index of first element to add and a current combination as arguments.
 * 
 * - if the current combination is done, we add the combination to the final output
 * - otherwise, we iterate over the indexes i from first to the length of the entire sequence n.
 *   - add integer nums[i] into the current combination curr.
 *   - proceed to add more integers into the combination: backtrack(i + 1, curr)
 *   - backtrack by removing nums[i] from curr 
 * 
 * 
 * 
 *
 */
public class SubSets78 {
	
	List<List<Integer>> output = new ArrayList<>();
	
	int n, k;
	
	
	public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
		
		// if the combination is done
		if(curr.size() == k) {
			output.add(new ArrayList<>(curr));
			return;
		}
		
		for(int i = first; i < n; i++) {
			// add i into the current combination
			curr.add(nums[i]);
			
			// use next integers to complete the combination
			backtrack(i + 1, curr, nums);
			
			//  backtrack
			curr.remove(curr.size() - 1);
			
		}
	}
	
	public List<List<Integer>> subsets(int[] nums){
		
		n = nums.length;
		for(k = 0; k < n + 1; k++) {
			backtrack(0, new ArrayList<Integer>(), nums);
		}
		
		return output;
	}

}


/**
 * time: O(N * 2^N) to generate all subsets and then copy them into output list.
 * 
 * space: O(N)
 * - we are using O(N) space to maintain curr, 
 *   and are modifying curr in-place with backtracking.
 * - Note that for space complexity analysis,
 *   we do not count space that is only used for the purpose of returing output,
 *   so the output array is ignored.
 * 
 */

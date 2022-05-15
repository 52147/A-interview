package vo;

import java.util.Arrays;

/**
 * 
 *Given an int array nums and an int target. Find two integers in nums such that the sum is closest to target.
 *
 *Example 1:
 *
 *Input: nums = [1, 2, 3, 4, 5], target = 10
 *Output: [4, 5]
 *Example 2:
 *
 *Input: nums= [-1, 2, 1, -4], target = 4
 *Output: [2, 1]
 *
 *https://leetcode.com/discuss/interview-question/241808/Google-Two-sum-closest
 *
 */
public class TwoSumCloseToTarget {
	
//	A better solution:
//		Time complexity: O(nlogn).
//		Space complexity: O(1).

		    public int[] twoSumClosest(int[] nums, int target) {
		        int minDiff = Integer.MAX_VALUE;
		        if (nums == null || nums.length == 0 || nums.length == 1) {
		            return null;
		        }
		        Arrays.sort(nums);
		        int start = 0;
		        int end = nums.length - 1;
		        int[] out = new int[2];
		        while (start < end) {
		            int sum = nums[start] + nums[end];
		            int diff = Math.abs(target - sum);
		            if(diff < minDiff) {
		                out[0] = nums[start];
		                out[1] = nums[end];
		                minDiff =  diff;
		            }

		            if (sum < target) {
		                start++;
		            } else if (sum > target) {
		                end--;
		            } else {
		                break;
		            }
		        }
		        return out;
		    }

}

package binarysearch;
/**
 * 
 * 35 Search Insert Position
 * 
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * 
 * if not return the index where it would be if it were inserted in order.
 * 
 * time must be O(log n)
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 * 
 * Approach : binary search
 * 
 * binary search : find the position of a target value
 * - we compare the target value to the middle element at each iteration
 * - If the target value is equal to the middle element, the job is done
 * - If the target value is less than the middle, continue to search on the left
 * - If the target value is greater than the middle, continue to search on the right.
 * 
 * 
 *  algorithm:
 *  1. left pointer = 0
 *      right pointer = n - 1(last index)
 *      
 *  2. while left <= right
 *     - compare middle nums[pivot] to the target value
 *     
 *       - if the middle is target, job done , return pivot
 *       
 *       - if is not 
 *         - target < nums[pivot] search on the left
 *           -> right = pivot - 1
 *           
 *         - else search on the right
 *           left = pivot + 1
 *           
 *   - return left
 */
public class SearchInsertPosition35 {
	
	public int searchInsert(int[] nums, int target) {
		
		int pivot; // middle index
		int left = 0;
		int right = nums.length - 1;
		
		while(left <= right) {
			
			pivot = left + (right - left)/2; 
			
			if(nums[pivot] == target) {return pivot;}
			
			if(target < nums[pivot]) {
				right = pivot - 1; // find the element at pivot left side, update the right to pivot - 1
				}else {
					left = pivot + 1; // find the element at pivot right side, update the left to pivot + 1
				}			
		}
		
		return left;
	}

}

/**
 * time: O(log N)
 * space: O(1)
 * 
 */

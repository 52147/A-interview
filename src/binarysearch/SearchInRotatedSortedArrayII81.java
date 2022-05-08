package binarysearch;
/**
 * 
 * 81. Search in Rotated Array II
 * 
 * - an integer array nums sorted in non-decreasing order
 * - nums is rotated at an unknown pivot index k
 * 
 * - given the array nums after the rotation and an integer target,
 *   return true if target is in nums,
 *   or false if it is not in nums
 *   
 *   Input: nums = [2,5,6,0,0,1,2], target = 0
 *   Output: true
 *   
 *   
 *   Approach : binary search
 *   
 *   this problem is an extension to 33. search in rotated sorted array.
 *   the only difference is that this problem allows duplicate elements.
 *   
 * Algorithm:
 *
 * Recall that in standard binary search, we keep two pointers (i.e. start and end) to track the search scope in an arr array. We then divide the search space in three parts [start, mid), [mid, mid], (mid, end]. Now, we continue to look for our target element in one of these search spaces.
 *
 * By identifying the positions of both arr[mid] and target in F and S, we can reduce search space in the very same way as in standard binary search:
 * 
 * Case 1: 
 * arr[mid] lies in F, target lies in S: 
 * Since S starts after F ends, we know that element lies here:(mid, end].
 *
 * Case 2: 
 * arr[mid] lies in the S, target lies in F: 
 * Similarly, we know that element lies here: [start, mid).
 * 
 * Case 3: 
 * Both arr[mid] and target lie in F: 
 * since both of them are in same sorted array, 
 * we can compare arr[mid] and target in order to decide how to reduce search space.
 * 
 * Case 4: 
 * Both arr[mid] and target lie in S: 
 * Again, since both of them are in same sorted array, 
 * we can compare arr[mid] and target in order to decide how to reduce search space.
 * 
 * But there is a catch, 
 * if arr[mid] equals arr[start], 
 * then we know that arr[mid] might belong to both F and S 
 * and hence we cannot find the relative position of target from it.
 *
 *
 */
public class SearchInRotatedSortedArrayII81 {
	
	public boolean search(int[] nums, int target) {
		
		int n = nums.length;
		if(n == 0) {
			return false;
		}
		
		int end = n - 1;
		int start = 0;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(nums[mid] == target) {
				return true;
			}
			
			if(!isBinarySearchHelpful(nums, start, nums[mid])) {
				start++;
				continue;
			}
			
			// which array does pivot belong to.
			boolean pivotArray = existInFirst(nums, start, nums[mid]);
			
			// which array does target belong to.
			boolean targetArray = existInFirst(nums, start, target);
			
			// if pivot and target exist in different sorted arrays,
			// recall that xor is true when both operand are distinct
			if(pivotArray ^ targetArray) { // ^ xor exclusive or
				
				if(pivotArray) {
					start = mid + 1; // pivot in the first, target in the second
				}else {
					end = mid - 1; // target in the first, pivot in the second
				}
			
			}else { // if pivot and target exist in same sorted array
				
				if(nums[mid] < target) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
		}
		
		return false;
	}
	
	// return true if we can reduce the search space in current binary search space
	private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
		return arr[start] != element;
	}
	
	// return true if element exists in first array,
	// false if it exists in second
	private boolean existInFirst(int[] arr, int start, int element) {
		return arr[start] <= element;
	}

}
/**
 * Time complexity : O(N) worst case, O(logN) best case, where N is the length of the input array.
 *
 * - Worst case: 
 *   - This happens when all the elements are the same and we search for some different element. 
 *   - At each step, we will only be able to reduce the search space by 1 since arr[mid] equals arr[start] 
 *     and it's not possible to decide the relative position of target from arr[mid]. Example: [1, 1, 1, 1, 1, 1, 1], target = 2.
 *
 * - Best case: 
 *   - This happens when all the elements are distinct. 
 *   - At each step, we will be able to divide our search space into half just like a normal binary search.
 *
 * - This also answers the following follow-up question:
 *
 * - Would this (having duplicate elements) affect the run-time complexity? How and why?
 *   - As we can see, by having duplicate elements in the array, we often miss the opportunity to apply binary search in certain search spaces. 
 *   - Hence, we get O(N) worst case (with duplicates) vs O(logN) best case complexity (without duplicates).
 *
 * Space complexity : O(1).
 * 
 * 
 */







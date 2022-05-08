package binarysearch;
/**
 * 
 * 33. Search In Rotated Sorted Array
 * 
 * a integer array nums sorted in ascending order
 * 
 * nums is possibly rotated 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * You must write an algorithm with O(log n) runtime
 * 
 * Approach: one-pass binary search
 * 
 * The idea is that we add additional condition checks in the normal binary search 
 * in order to better narrow down the scope of the search.
 * 
 * algorithm:
 * 
 * - In the normal binary search, we keep 2 pointers (start and end) to track the search scope.
 * - At each iteration, we reduce the search scope into half, by moving either start or end pointer to the middle of the previous search scope.
 * 
 * 
 * - here is the detailed breakdowns of the algorithm:
 *   - initiate the pointer start to 0, and the pointer end to n - 1
 *   - perform standard binary search. While start <= end:
 *     - take an index in the middle mid as a pivot
 *     - if nums[mid] == target, the job is done, return mid
 *     
 *     - now, there could be 2 situations:
 *       - pivot element is larger than the first element in the array
 *         i.e. the subarray from the first element to the pivot is non-rotated,
 *         
 *         - if the target is located in the non-rotated subarray:
 *           - go left: 'end = mid - 1'
 *           - otherwise: go right: 'start = mid + 1'
 *       
 *       - pivot element is smaller than the first element of the array.
 *         i.e. the rotation index is somewhere between 0 and mid
 *         it implies that the sub-array from the pivot element to the last one is non-rotated
 *         
 *         - if the target is located in the non-rotated subarray:
 *           - go right: 'start = mid + 1'
 *           - otherwise: go left 'end = mid -1'
 *           
 *       - We're here because the target is not found. return -1.
 *       
 *        
 * 
 * 
 *
 */
public class SearchInRotatedSortedArray33 {
	
	
	public int search(int[] nums, int target) {
		
		int start = 0;
		int end = nums.length- 1;
		
		while(start <= end) {
			
			int mid = start + (end - start) / 2;
			
			if(nums[mid] == target) {
				
				return mid;
				
			}else if(nums[mid] >= nums[start]) { // start to mid is not rotated(ascending order)
				
				if(target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			
			}else { // mid to end is not rotated (ascending order)
				
				if(target <= nums[end] && target > nums[mid]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
			
			
		}
		return -1;
		
		}

}
/**
 * time: O(log N)
 * space: O(1)
 */





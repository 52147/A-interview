package twopointers;
/**
 * 
 * 977. Squares of a Sorted Array
 * 
 * square each number in array and sorting in non-decreasing order
 * 
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * 
 * 
 * Approach : Two pointer
 * 
 * using two pinter to compare the abs element in the left and right
 * 
 * a for loop to traverse all value in the array from back to start
 *  use abs method in left and right because array may has negative number
 *    (negative number after square may be bigger than the positive number )
 *  if 
 *   abs left < abs right
 *   assign right to square
 *   move the right pointer to the next position right--
 *  
 *  else
 *  
 *   abs left > abs right
 *   assign left to square
 *   move the left pointer to the next position left++
 *  
 *  
 *  assign square * square to result[i] // result array is ascending number
 *                                      // for loop traverse form last 
 *                                      // so assign the bigger number to result[i]
 *  
 *  
 * outside for loop
 * 
 * return result array as answer
 *
 */
public class SquaresOfASortedArray {
	
	public int[] sortedSquares(int[] nums) {
		
		int n = nums.length;
		int[] result = new int[n];
		int left = 0;
		int right = n - 1;
		
		for(int i = n - 1; i >= 0; i--) {
			
			int square;
			
			if(Math.abs(nums[left]) < Math.abs(nums[right])) {
				
				square = nums[right];
				right--;
			}else {
				square = nums[left];
				left++;
			}
			
			result[i] = square * square;
		}
		
		return result;
	}

}
/**
 * time: O(N) , n is the length of given array
 * space: O(N) if take output into account
 * 
 */




package vo;
/**
 * 
 * 238. Product of Array Except Self
 * 
 * - Given an integer array nums, 
 *   return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * - must write an algorithm that runs in O(n) time and without using the division operation.
 * 
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 * Algorithm:
 * 
 * 1. 
 *   - Initialize 2 empty arrays, L and R where for a given index i,
 *   - L[i] would contain the product of all the numbers to the left of i and R[i] would contain the product of all the numbers to the right of i.
 * 
 * 2. 
 *   - We would need two different loops to fill in values for the two arrays.
 *   - For the array L, L[0] would be 1 since there are no elements to the left of the first element.
 *   - For the rest of the elements, we simply use L[i] = L[i - 1] * nums[i - 1].
 *   - Remember that L[i] represents product of all the elements to the left of element at index i.
 *   
 * 3. 
 *   - For the other array,
 *     we do the same thing but in reverse i.e. we start with the initial value
 *     of 1 in R[length - 1] where length is the number of elements in the array,
 *     and keep updating R[i] in reverse.
 *   - Essentially, R[i] = R[i + 1] * nums[i + 1].
 *   - Remember that R[i] represent product of all elements to the right of element at index i.
 *   
 * 4. 
 *   - Once we have the two arrays set up properly,
 *     we simply iterate over the input array one element at a time,
 *     and for each element at index i,
 *     we find the product except self as L[i] * R[i].
 *     
 */
public class ProductOfArrayExceptSelf238 {
	
	public int[] productExceptSelf(int[] nums) {
		
		// The length of the input array
		int length = nums.length;
		
		// The left and right arrays as described in the algorithm
		int[] L = new int[length];
		int[] R = new int[length];
		
		// Final answer array to the returned
		int[] answer = new int[length];
		
		// L[i] contains the product of all the elements to the left
		// Note: for the element at index '0',
		// there are no elements to the left,
		// so L[0] would be 1.
		L[0] = 1;
		for(int i = 1; i < length; i++) {
			// L[i - 1] already contains the product of elements to the left of 'i - 1'
			// Simply multiple it with nums[i - 1] would give the product of all 
			// elements to the the left of index 'i'
			L[i] = nums[i - 1] * L[i - 1];
		}
		
		// R[i] contains the product of all the elements to the right
		// Note: For the element at index 'length - 1',
		// there are no elements to the right,
		// so the R[length - 1] would be 1
		R[length - 1] = 1;
		for(int i = length - 2; i >= 0; i--) {
			
			// R[i + 1] already contains the product of elements to the right of 'i + 1'
			// Simply multiplying it with nums[i + 1] would give the product of all elements to the right of index 'i'
			R[i] = nums[i + 1] * R[i + 1];
			
		}
		
		// Constructing the answer array
		for(int i = 0; i < length; i++) {
			// For the first element, R[i] would be product except self
			// For the last element, product except self self would be L[i]
			// Else, multiple product of all elements to the left and to the right 
			answer[i] = L[i] * R[i];
			
		}
		
		return answer;
		
	}

}


/**
 *  Time: O(N)
 *  - where N represents the number of elements in the input array.
 *  - We use one iteration to construct the array L,
 *    one to construct the array R and one last to construct the answer array using L and R.
 *    
 *  Space: O(N)
 *  - used up by the two intermediate arrays
 *    that we constructed to keep track of product of elements to the left and right.
 */




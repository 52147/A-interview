package vo;

import java.util.Arrays;

// 1099. two sum less than k
// given an array and integer k
// return maximum sum and sum < k
// if nums[i] and num[j] not exist
// retun -1

// approach : two pointer
// 1. sort the array (because we want to find the sum is most close to k )
// 2. set two pointer left and right / int ans = -1 use this variable to record the max value clos to k
// 3. while loop(left < right)
//    sum = left + right
//     if(target < sum)
//         update the max in max
//         left++
//     else(target > sum)
//         right--
//     return answer

// time: O(n log n)  // space : O(log n) to O(n)
public class TwoSumLessThanK1099 {
	
	public int twoSumLessThanK(int[] nums, int k) {
		
		Arrays.sort(nums); // time : sort O(log n) // space : O(log n) to O(n) (in place sort)
		int left = 0;
		int right = nums.length - 1;
		int result = -1;
		
		// time : O(n)
		while(left < right) {
			int sum = nums[left] + nums[right];
			
			if(k > sum) {
				left++;
				result = Math.max(result, sum);
			}else {
				right--;
			}
		}
		
		return result;
		
	}

}

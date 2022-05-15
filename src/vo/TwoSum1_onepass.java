package vo;

import java.util.HashMap;

// 1. two sum
// if two value in the array add together is equal to target
// we return the two value index
// if can find the result 
// return null
// each input has one solution and can not use the same element twice

// approach: two pass(two iteration)
// 1. for loop : use a hashmap to store the number as key and index as value
// 2. second for loop:
//    find the target - nums[i] = key in the hashmap(and it value can not be the i)
//    => found => return new int[] with index


// approach: one pass solution (one iteration)
// reduce the first solution
// and put the add key and value in the second for loop end
public class TwoSum1_onepass {
	
	public int[] twoSum(int[] nums, int target) {
		
		// space: O(n) the number of items stored in the hash table
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		// time: O(n) we traverse the list containing n elements twice
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			
			if(map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {map.get(complement), i};
			}
			
		}
		return null;
	}
	
	
	public int[] TwoSum_one(int nums[], int target) {
		// space O(n)
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// time O(n)
		for(int i = 0; i < nums.length; i++) {
			int com = target - nums[i];
			// each containsKey operation O(1)
			if(map.containsKey(com)) {
				return new int[] {map.get(com), i};
			}
			
			map.put(nums[i], i); // add the key and value here because first iteration we won't get the answer because it only have one value 
			                     // and we can not use the same value twice
		}
		
		return null;
	}

}

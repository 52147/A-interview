package vo;

import java.util.Arrays;
import java.util.HashMap;

public class HowManyNumbersAreSmallerThanTheCurrentNumber1365 {
	
	public int[] smallerNumbersThanCurrent(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		
		int[] copy = nums.clone();
		
		Arrays.sort(copy);
		
		for(int i = 0; i < nums.length; i++) {
			map.putIfAbsent(copy[i], i);
		}
		
	}

}

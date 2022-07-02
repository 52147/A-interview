package vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 3. Longest substring without repeating characters
 * 
 * approach: sliding window optimized
 * 
 * - we could define a mapping of the characters to its index.
 * - Then we skip the characters immediately when we found a repeated character.
 * 
 *
 */
public class LongestSubstringWithoutRepeatingCharacters3_slidingwindowoptimized {
	
	public int lengthOfLongestSubstring(String s) {
		
		int n = s.length();
		int ans = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		// current index of character
		
		// try to extend the range [i, j]
		for(int r = 0, l = 0; r < n; r++) {
			if(map.containsKey(s.charAt(r))) {
				l = Math.max(map.get(s.charAt(r)), l);
			}
			
			ans = Math.max(ans, r - l + 1);
			
			map.put(s.charAt(r), r + 1);
		}
		
		return ans;
	}

}

/**
 * 
 * time : O(n). index r will iterate n time(length of the string)
 * space(HashMap): O(min(m, n)) 
 * 
 * 
 */



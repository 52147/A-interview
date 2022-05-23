package vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 49. Group Anagrams
 * 
 * - Given an array of strings strs, group the anagrams together.
 * - can return the answer in any order.
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Approach : Categorize by Count
 * 
 * Algorithm:
 * - We can transform each string s into character count, count, consisting of 26 non-negative integers 
 *   representing the number of a's, b's, c's etc.
 * - We use these counts as the basis for our hash map.
 * 
 * - In Java, the hashable representation of our count will be a string delimited with '#' characters.
 *   - For example, abbccc will be #1#2#3#0#0#0...#0 where there are 26 entries total.
 *   
 *
 */
public class GroupAnagram49 {
	
	
	public List<List<String>> groupAnagrams(String[] strs){
		
		if(strs.length == 0) {
			return new ArrayList();
			
		}
		
		Map<String, List> ans = new HashMap<String, List>();
		
		int[] count = new int[26];
		
		for(String s: strs) {
			
			Arrays.fill(count, 0);
			
			for(char c: s.toCharArray()) {
				count[c - 'a']++;
			}
			
			StringBuilder sb = new StringBuilder("");
			
			for(int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			
			String key = sb.toString();
			
			if(!ans.containsKey(key)) {
				ans.put(key, new ArrayList<>());
			}
			
			ans.get(key).add(s);
		}
		
		return new ArrayList(ans.values());
	}

}
/**
 * 
 * Time Complexity: O(NK), 
 * - where N is the length of strs, and K is the maximum length of a string in strs. 
 * - Counting each string is linear in the size of the string, and we count every string.
 * 
 * Space Complexity: O(NK), the total information content stored in ans.
 */





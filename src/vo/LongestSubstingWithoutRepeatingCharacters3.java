package vo;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating character.
 * 
 * 
 * Example 1:
 *
 *Input: s = "abcabcbb"
 *Output: 3
 *Explanation: The answer is "abc", with the length of 3.
 *Example 2:
 * 
 *Input: s = "bbbbb"
 *Output: 1
 *Explanation: The answer is "b", with the length of 1.
 *Example 3:
 * 
 *Input: s = "pwwkew"
 *Output: 3
 *Explanation: The answer is "wke", with the length of 3.
 *Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * Approach: Sliding window
 * 
 * 
 * - if a substring sij from index i to j - 1 is already checked to have no duplicate characters.
 * - We only need to check if s[j] is already in the substring sij.
 * 
 * - To check if a character is already in the substring,
 *   we can scan the substring, which leads to an O(n^2). But we can do better.
 * - By using HashSet as a sliding window,
 *   checking if a character in the current can be done in O(1).
 *   
 * - A sliding window is an abstract concept commonly used in array/ string problems.
 * - A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i,j) (left-closed, right-open).
 * - A sliding window is a window "slides" its two boundaries to the certain direction.
 *   - For example, if we slide [i,j) to the right by 1 element,
 *     then it becomes [i+1, j+1) (left-closed, right-open)
 *     
 * - We use HashSet to store the characters in current window [i,j) (j = i initially).
 * - Then we slide the index j to the right.
 * - If it is not in the HashSet, we slide j further.
 * - Doing so until s[j] is already in the HashSet.
 * - At this point, we found the maximum size of substrings without duplicate characters start with index i.
 * - If we do this for all i, we get our answer.
 * 
 *  Approach: Sliding window optimized(using HashMap)
 *  - The above solution requires at most 2n steps.
 *  - In fact, it could be optimized to require only n steps.
 *  - Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index.
 *  - Then we can skip the characters immediately when we found a repeated character.
 *  
 *  - The reason is that if s[j] have duplicate in the range [i, j) with index j',
 *    we don't need to increase i little by little.
 *  - We can skip all the elements in the range [i, j') and let i to be j' + 1 directly.
 * 
 *
 */
public class LongestSubstingWithoutRepeatingCharacters3 {
	
	public int lengthOfLongestSubstring(String s) {
		int[] chars = new int[128]; // all the character can be encoded in the integers
		
		int left = 0; // contract the window
		int right = 0; // extend the window
		
		int res = 0;
		
		while(right < s.length()) {
			
			char r = s.charAt(right); // we obtain the character at the right boundary
			chars[r]++; // add this character's occurrence
			
			
			// contracting the window
			// if the character at the right boundary appears more than once
			// we need to keep contracting the window
			while(chars[r] > 1) {
				char l = s.charAt(left);  // get the left character at the left boundary
				chars[l]--; // reduce the occurrence
				left++; // move forward the left pointer
			}
			
			// after contracting the window
			// we can make sure there is no duplicate in the current window
			res = Math.max(res, right - left + 1); // so we can update our result using the current window's length
			
			right++; // keep extending the window
		}
		return res;
	}
	
	
	 // Approach: Sliding window optimized(using HashMap)
	public int lengthOfLongestSubstring2(String s) {
		
		int n = s.length();
		int ans = 0;
		
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		
		// try to extend the range [i, j]
		for(int j = 0, i = 0; j < n; j ++) {
			
			if(map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		
		return ans;
		
	}

}
/**
 * Approach 1: sliding window
 * time: O(2n) = O(n) 
 * - In the worst case each character will be visited twice by i and j.
 * 
 * space: O(min(m, n))
 * - We need O(k) space for the sliding window, where k is the size of the set.
 * - The size of the set is upper bounded by the size of the string n and the size of the charset/alphabet m.
 * 
 */



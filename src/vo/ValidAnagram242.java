package vo;
/**
 * 242. valid anagram
 * 
 * - given two string s and t, return true if t is an angram of s, and false otherwise
 * 
 * anagram: is a word or phase formed by rearangeing the letters of a different word or phase, typically using all the original letters exactly once.
 * 
 *Example 1:
 *
 *Input: s = "anagram", t = "nagaram"
 *Output: true
 *Example 2:
 *
 *Input: s = "rat", t = "car"
 *Output: false
 *
 *
 * Approach : frequency counter
 * 
 *  - To examine if t is rearrangement of s, we can count occurences of each letter in the 2 strings and compare them.
 *  - We could use a hash table to count the frequency of each letter,
 *    however, since both s and t only contains letters from a to z, 
 *    simply array of size 26 will suffice.
 *  
 *  - we do not two counter for comparison?
 *    - because we can increment the count for each letter in s and decrement the count for each letter in t,
 *      and then check if the count for every character is zero.
 *      
 */
public class ValidAnagram242 {
	
	public boolean isAnagram(String s, String t) {
		
		if(s.length() != t.length()) {
			return false;
		}
		
		int[] counter = new int[26]; // space: O(1) Although we do use extra space, the space is O(1) because the table's size stays constant no matter how large n is.
		
		// time: O(n) 
		for(int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		
		for(int count : counter) {
			
			if(count != 0) {
				return false;
			}
		}
		
		return true;
	}

}

package vo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 151. Reverse Words in a String
 * 
 * given an input string s, reverse the order of the words.
 * return a string of the words in reverse order concatenated by a single space
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 * 
 * Example 1:
 *
 *Input: s = "the sky is blue"
 *Output: "blue is sky the"
 *Example 2:
 *
 *Input: s = "  hello world  "
 *Output: "world hello"
 *Explanation: Your reversed string should not contain leading or trailing spaces.
 *Example 3:
 *
 *Input: s = "a good   example"
 *Output: "example good a"
 *Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * 
 * 
 * Approach : Deque of Words
 * 
 * 1. trim leading and trailing spaces
 * 2. push word by word in front of deque
 * 3. join
 * 
 *
 */
public class ReverseWordsInAString151 {
	
	public String reverseWords(String s) {
		
		int left = 0;
		int right = s.length() - 1;
		
		// remove leading spaces
		while(left <= right && s.charAt(left) == ' ') left ++;
		
		// remove trailing spaces
		while(left <= right && s.charAt(right) == ' ') right--;
		
		Deque<String> d = new ArrayDeque<>();
		
		StringBuilder word = new StringBuilder();
		
		//push word by word in front of deque
		while(left <= right) {
			
			char c = s.charAt(left);
			
			if((word.length() != 0) && (c == ' ')) {
				d.offerFirst(word.toString()); // insert the element in front of deque
				word.setLength(0);
			}else if(c != ' ') {
				word.append(c);
			}
			
			left++;
		}
		
		d.offerFirst(word.toString());
		
		return String.join(" ", d); //   Returns a new String composed of copies of the CharSequence elements joined together with a copy of thespecified delimiter. 
	}
	


}

/**
 * time : O(N)
 * space : O(N)
 */

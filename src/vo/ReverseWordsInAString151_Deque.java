package vo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 
 * 151. Reverse Words in A string
 * 
 * Approach: Deque
 * 
 *
 */
public class ReverseWordsInAString151_Deque {
	
	public String reverseWords(String s) {
		int left = 0;
		int right = s.length() - 1;
		
		// remove leading spaces
		while(left <= right && s.charAt(left) == ' ') {
			left++;
		}
		
		while(right <= right && s.charAt(right) == ' ') {
			right--;
		}
		
		Deque<String> d = new ArrayDeque();
		
		StringBuilder word = new StringBuilder();
		
		// push word by word in front of deque
		while(left <= right) {
			
			char c = s.charAt(left);
			
			if((word.length() != 0) && (c == ' ')) {
				d.offerFirst(word.toString());
				word.setLength(0);
			}else if(c != ' ') {
				word.append(c);
			}
			
			left++;
		}
		
		d.offerFirst(word.toString());
		
		return String.join(" ", d);
		
		
	}
	
	
	public String reverse(String s) {
		// remove leading spaces
		s = s.trim();
		
		// split by multiple spaces
		List<String> wordList = Arrays.asList(s.split("\\s+"));
		
		Collections.reverse(wordList);
		
		return String.join(" ", wordList);
	}

}


/**
 * time : O(n)
 * space : O(n)
 * 
 */

package vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 17. Letter Combinations of a Phone Number
 *  
 *  Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *  Return the answer in ant order
 *  
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Approach: backtracking
 * 
 * Algorithm:
 * - we need to lock-in letters when we generate new letters.
 * - The easiest way to save state like this is to use recursion.
 * - 1. if the input is empty, return an empty array.
 * - 2. Initialize a data structure (e.g. a hash map) that maps digits to their letters,
 *      for example, mapping "6" to "m", "n"  and "o".
 * - 3. Use a backtracking function to generate all possible combinations.
 *      - The function should take 2 primary inputs:
 *        - the current combination of letters we have, path, and the index we are currently checking.
 *      - As a base case, if our current combination of letters is the same length as the input digits,
 *        that means we have a complete combination.
 *        - Therefore, add it to our answer, and back track.
 *      - Otherwise, get all the letters that correspond with the current digit we are looking at, digits[index].
 *      - Loop through these letters. For each letter, add the letter to our current path, and call backtrack again, 
 *        but move on to the next digit by incrementing index by 1.
 *      - Make sure to remove the letter from path once finished with it.
 * 
 * 
 * 
 *
 */
public class LetterCombinationsOfAPhoneNumber17 {
	
	private List<String> combinations = new ArrayList<>();
	private Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
	
	private String phoneDigits;
	
	public List<String> letterCombinations(String digits){
		// If the input is empty, immediately return an empty answer array
		if(digits.length() == 0) {
			return combinations;
		}
		
		// Initiate backtracking with an empty path and starting index of 0
		phoneDigits = digits;
		
		backtrack(0, new StringBuilder());
		
		return combinations;
	}
	
	private void backtrack(int index, StringBuilder path) {
		// If the path is the same length as digits, we have a complete combination.
		if(path.length() == phoneDigits.length()) {
			combinations.add(path.toString());
			
			return; // backtrack
		}
		
		// get the letters that the current digit maps to, and loop through them
		String possibleLetters = letters.get(phoneDigits.charAt(index));
		for(char letter: possibleLetters.toCharArray()) {
			// add the letter to our current path
			path.append(letter);
			// move on to the next digit
			backtrack(index + 1, path);
			// backtrack by removing the letter before moving onto the next
			path.deleteCharAt(path.length() - 1);
		}
	}
	

}

/**
 * time: O(4^N * N), where N is the length of digits.
 * - Note that 4 in this expresiion is referring to the maximum value length in the hash map,
 *   and not to the length of the input.
 * - The worst-case is where the input consists of only 7s and 9s.
 * - In the case, we have to explore 4 additional path for every extra digit.
 * - Then, for each combination, it costs up to N to builde the combination.
 * - This problem can be generalized to a scenario where numbers correspond with up to M digits, in which case the time complexity
 *   would be O(M^ N *⋅N). For the problem constraints, we're given, M=4, because of digits 7 and 9 having 4 letters each.
 *   
 *   
 * Space complexity: O(N), where NN is the length of digits.
 * - Not counting space used for the output, 
 *   the extra space we use relative to input size is the space occupied by the recursion call stack. It will only go as deep as the number of digits in the input since whenever we reach that depth, we backtrack.
 * - As the hash map does not grow as the inputs grows, it occupies O(1) space.
 */




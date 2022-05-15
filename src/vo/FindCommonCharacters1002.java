package vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1002. Find Common Characters
// given a  string array
// return string that all string has (including duplicate)


public class FindCommonCharacters1002 {
	
	public List<String> commonChars(String[] A){
		
		List<String> ans = new ArrayList<>();
		
		int[] commonCount = new int[26];
		
		Arrays.fill(commonCount, Integer.MAX_VALUE);
		
		
		for(String a: A) {
			int[] count = new int[26];
			for(char c: a.toCharArray()) {
				count[c - 'a']++;				
			}
			// find the intersection of the character 
			for(int i = 0; i < 26; i++) {
				commonCount[i] = Math.min(commonCount[i], count[i]);
			}
		}
		
		for(char c = 'a' ; c <= 'z'; c++) {
			for(int i = 0; i < commonCount[c - 'a']; i++) {
				ans.add(String.valueOf(c));
			}
		}
		
		return ans;
		
		
	}

}

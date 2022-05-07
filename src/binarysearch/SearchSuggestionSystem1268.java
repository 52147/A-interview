package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
  * 
  * 1268. Search Suggestion System
  * 
  * given an array of strings products and a string searchWord
  * 
  * Design a system that suggests at most 3 product names from products
  * after each character of searchWord is typed.
  * 
  * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
  * Output: [
  * ["mobile","moneypot","monitor"],
  * ["mobile","moneypot","monitor"],
  * ["mouse","mousepad"],
  * ["mouse","mousepad"],
  * ["mouse","mousepad"]
  * ]
  * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
  * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
  * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
  * 
  * Approach 1: Binary Search
  * 
  * Algorithm:
  * 
  * 1. sort input products
  * 2. iterate each character of the searchWord adding it to the prefix to search for
  * 3. After adding the current character to the prefix binary search tree
  * 4. add next 3 string from the current binary search start index until the prefix remains same
  * 5. Another optimization that can be done is reducing the bstree space to current start index.
  *    (this is due to the fact that adding more characters to the prefix will make the next search result's index be at least > current search's index).
  * 
  * 
  * 
  * 
  */
public class SearchSuggestionSystem1268 {
	
	// equivalent code for lower_bound in java
	int lower_bound(String[] products, int start, String word) {
		
		int i = start;
		int j = products.length;
		int mid;
		
		while(i < j) {
			
			mid = (i + j)/2;
			
			if(products[mid].compareTo(word) >= 0) {
				
				j = mid;
			}else {
				i = mid + 1;
			}
		}
		
		return i;
	}
	
	public List<List<String>> suggestedProducts(String[] products, String searchWord){
		
		Arrays.sort(products);
		
		List<List<String>> result = new ArrayList<>();
		
		int start = 0;
		int bsStart = 0;
		int n = products.length;
		
		String prefix = new String();
		
		for(char c: searchWord.toCharArray()) {
			prefix += c;
			
			// get the starting index of word starting with 'prefix'
			start = lower_bound(products, bsStart, prefix);
			
			// Add empty vector to result
			result.add(new ArrayList<>());
			
			// Add the words with the same prefix to the result.
			// Loop runs until 'i' reaches the end of input or 3 times or till the 
			// predix is same for 'products[i]' whichever comes first.
			for(int i = start; i < Math.min(start + 3, n); i++) {
				
				if(products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix)) {
					break;
					
					
				}
				
				result.get(result.size() - 1).add(products[i]);
			}
			
			// reduce the size of elements to binary search on since we know
			bsStart = Math.abs(start);
			
		}
		
		return result;
		
		
	}
	
	

}
/**
 * Time: O(nlog(n)) + O(mlog(n))
 *  - where n is the length of products and m is the length of the search word.
 *  - here we treat string comparison in sorting as O(1).
 *  - O(nlog(n)) comes from the sorting 
 *    and O(mlog(n)) comes from running binary search on products m times,
 *    - in java, there is an additional complexity of O(m^2) due to strings being immutable,
 *      here m is the length of searchWord
 * 
 * Space: 
 *  - Varies between O(1) and O(n) where n is the length of products
 *    , as it depends on the implementation used for sorting.
 *  - We ignore the space required for output as it does not affect the algorithm's space complexity. 
 *  - Space required for output is O(m) where m is the length of the search word.
 *        
 */




package vo;
/**
 * 
 * 451. Sort Characters by frequency
 * 
 * Approach : Multiset and bucket sort
 * 
 * Intuition:
 * - While the second approach is probably adequate for an interview,
 *   there is actually a way of solving this problem with a time complexity O(n).
 * 
 * - Firstly, observe that because all of the characters came out of a String of length n,
 *   the maximum frequency for any one character is n.
 * - This means that once we've determined all the letter frequencies using a HashMap,
 *   we can sort them in O(n) time using Bucket Sort.
 * - Recall that for our previous approaches,
 *   we used comparsion based sorts, which have a cost of O(n log n).
 *   
 * - Recall the Bucket Sort is the sorting algorithm where item are placed at Array indexs based on their values.
 *   (the indexes are called "buckets").
 * - For this problem, we'll need to have a List of characters at each index.
 * - For example, here is how our String from before goes into the buckets.
 * 
 * - While we could simply make our bucket Array length n,
 *   we're best to just look for the maximum value(frequency) in the HashMap.
 * - That way, we only use as much space as we need,
 *   and won't need to iterate over heaps of empty buckets during the next phase.
 *   
 * - Finally, we need to iterate over the buckets, starting with the largest and ending with the smallest,
 *   building up the string in much the same way as we did before.   
 * 
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency451_BucketSort {
	
	public String frequencySort(String s) {
	
	if(s == null || s.isEmpty())
		return s;
	
	// count up the occurrences
	Map<Character, Integer> counts = new HashMap<>();
	
	for(char c : s.toCharArray()) {
		counts.put(c, counts.getOrDefault(c, 0) + 1);
	}
	
	int maximumFrequency = Collections.max(counts.values());
	
	// make the list of buckets and apply bucket sort.
	List<List<Character>> buckets = new ArrayList<>();
	
	for(int i = 0; i <= maximumFrequency; i++) {
		buckets.add(new ArrayList<>());
	}
	
	for(Character key : counts.keySet()) {
		int freq = counts.get(key);
		buckets.get(freq).add(key);
	}
	
	// build up the string
	StringBuilder sb = new StringBuilder();
	for(int i = buckets.size() - 1; i >= 1; i--) {
		for(Character c : buckets.get(i)) {
			for(int j = 0; j < i ; j++) {
				sb.append(c);
			}
		}
	}
	
	return sb.toString();
	}
}

/**
 * Complexity Analysis:
 * 
 * - Let n be the length of the input String.
 * - The k(number of unique characters in the input String that we considered for the last approach makes no difference this time.)
 * 
 * Time: O(n)
 * - Like before, the HashMap building has a cost of O(n).
 * - The bucket sorting is O(n),
 *   because inserting item has a cost of O(k)(each entry from the HashMap),
 *   and building the buckets initially has a worst case of O(n) (which occurs when k = 1).
 * - Because k <= n, we're left with O(n).
 * - So in total, we have O(n).
 * 
 * Space: O(n)
 * - Same as above.
 * - The bucket Array also uses O(n) space, 
 *   because its length is at most n,
 *   and there are k item across all the buckets.
 */



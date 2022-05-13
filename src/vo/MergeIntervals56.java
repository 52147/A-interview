package vo;

import java.util.Arrays;
import java.util.LinkedList;
// 56. Merge Intervals
//Example 1:
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//Example 2:
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.

// 56. merge intervals (sorting + linkedlist)
// merge the two array interval part
// output 2d array
// 1. sort the interval[0] in the ascending order 
// 2. use for loop to traverse the 2d array intervals
//     - use linked list to compare each interval[1] end with next interval[0] start
//     - if end is less than next interval start(or empty) => represent not overlap => directly add it to the linked list(no need to change the interval)
//     - if end is bigger than the next interval start => represent overlap
//       => change the first interval(the list is already in the linked list) end with the larger of first interval end between second interval end
// 3. put the linkedlist result to array
// 4. return the 2d array

public class MergeIntervals56 {
	
	public int[][] merge(int[][] intervals){
		
		// first sort the interval with each start in ascending order
		Arrays.sort(intervals, (a, b) ->Integer.compare(a[0], b[0])); // sort : time O(log N) // space: sort in place O(n) , not O(log n)
		
		
		// when we need to compare the index value in each array in the 2d array and change the value and return the array in order
		// we can use linked list <int[]>
		// because link list getlast() can get the data of the last add it to the linked list and can use it to compare the value in the next array
		LinkedList<int[]> merged = new LinkedList<>();
		
		// scan the list : O(n) // total time : O(n log(n))
		for(int[] interval : intervals) {
			
			if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			}else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}
		
		return merged.toArray(new int[merged.size()][]);
	
		
	}

}

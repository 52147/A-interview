package binarysearch;
/**
 * 
 * 74. Search a 2D Matrix
 * 
 * - write an efficient algorithm that searches for a value target in an m*n integer matrix.
 * - This matrix has the following properties:
 *   - Integers in each row are sorted from left to right
 *   - The first integer of each row is greater than the last integer of the previous row.
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * 
 * Approach : binary search
 * 
 * - the input matrix m * n could be considered as a sorted array of length m*n
 * 
 * - sorted array is perfect candidate for the binary search 
 *   because the element index in this virtual array
 *   could be easily transformed into the row and column in the initial matrix.
 *   
 *   n: the length of the col
 *   idx: index in the array
 *   row = idx / n
 *   col = idx % n
 *   
 *  Algorithm:
 *   - The algorithm is a standard binary search:
 *   
 *     - initialise left and right indexes left = 0 and right = m*n - 1
 *     
 *     - while left <= right:
 *       - pick up the index in the middle of the virtual arrays as a pivot index:
 *         pivot_idx = (left + right) / 2
 *         
 *       - The index corresponds to row = pivot_idx / n and col = pivot_idx % n in the initial matrix,
 *         and hence one could get the pivot_element.
 *         This element splits the virtual array in 2 parts.
 *       
 *       - Compare pivot_element and target to identify in which part one has to look for target.
 *       
 * 
 */
public class SearchA2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		
		int m = matrix.length;
		if(m == 0) {
			return false;
		}
		
		int n = matrix[0].length;
		
		// binary search
		int left = 0;
		int right = m * n - 1;
		
		int pivotIdx;
		int pivotElement;
		
		while(left <= right) {
			
			pivotIdx = (left + right) / 2;
			
			pivotElement = matrix[pivotIdx / n][pivotIdx % n];
			
			if(target == pivotElement) {
				return true;
			}else {
				
				if(target < pivotElement) {
					right = pivotIdx - 1;
				}else {
					left = pivotIdx + 1;
				}
			}
		}
		
		return false;
	}

}
/**
 * time: O(log(mn)) since it is a standard binary search
 * space: O(1)
 */



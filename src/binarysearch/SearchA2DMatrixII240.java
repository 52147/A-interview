package binarysearch;
/**
 * 
 * 240. Search a 2D Matrix II
 * 
 * - write an efficient algorithm that searches for a value target in an m * n integer matrix.
 * 
 * - the matrix has the following properties:
 * 
 *   - Integers in each row are sorted in ascending from left to right.
 *   - Integers in each column are sorted in ascending from top to bottom.
 *   
 * 
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true  
 * 
 * 
 *  Approach : search space reduction
 *  
 *  Intuition:
 *  - Because the rows and columns of the matrix are sorted (from left-to-right and top-to-bottom)
 *    , we can prune O(m) or O(n) elements when looking at any particular value.
 *    
 *  Algorithm:
 *  
 *   1. first, we initialize a (row, col) pointer to the bottom-left of the matrix.
 *      then, until we find target and return true(or the pointer points to a (row, col) that lies outside of the dimensions of the matrix),
 *      
 *       we do following:
 *         - if the currently-pointed-to value is smaller than target,
 *           we can move one column "right".
 *         
 *         - because the rows are sorted from left-to-right, 
 *           we know that every value to the right of the current value is larger. 
 *         - Therefore, if the current value is already larger than target, 
 *           we know that every value to its right will also be too large. 
 *           
 *         - A very similar argument can be made for the columns.
 *
 */
public class SearchA2DMatrixII240 {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		
		// start our "pointer" in the bottom-left
		int row = matrix.length - 1;
		int col = 0;
		
		while(row >= 0 && col < matrix[0].length) {
			
			if(matrix[row][col] > target) {
				row--;
			}else if(matrix[row][col] < target) {
				col++;
			}else {
				// found it
				return true;
			}
		}
		
		return false;
	}

}


/**
 * time: O(n + m)
 * - on every iteration (during which we do not return true) either row or col is decremented/incremented exactly once.
 * 
 * - because row can only be decremented m times and col can only be incremented n times before causing the while loop to terminate,
 *   the loop can not run for more than n + m iterations.
 * 
 * - because all other work is constant, the overall time complexity is linear in the sum of the dimensions of the matrix.
 * 
 * space: O(1)
 * 
 * - only manipulates a few pointers, its memory footprint is constant.
 * 
 * 
 * 
 */

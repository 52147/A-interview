package vo;

import java.util.HashSet;

/**
 * 
 * 36 valid sudoku
 * 
 *  determine if a 9 * 9 sudoku board is valid.
 *  
 *   rule:
 *   1. each row contain digits 1-9 without repetition
 *   2. each col contain digits 1-9 without repetition
 *   3. each 3*3 box of the grid must contain digits 1-9 without repetition
 *  
 *  Input: board = 
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * 
 * 
 * algorithm:
 * 
 * 1. initialize a list contain 9 hash sets, where the hash set at index r
 *    will be used to store previously seen numbers in row r of the sudoku.
 *    Likewise, initialize lists of 9 hash sets to track the col and boxes too.
 *    
 * 2. iterate over each position (r, c)
 *    At each iteration, if there is a number at the current position.
 *    
 *    - check is the number exists in the hashset in the rowm col and box.
 *      - if it does, return false.
 *      - because this is the second occurrence of the number in the row, col or box.
 *    
 *    - otherwise, update the set for tracking numbers in the current row, col and box
 *    - the index of the box is (r/3)*3 + (c/3)
 *    
 *  3. if no duplicate were found after every position on the sudoku,
 *     then the sudoku is valid, so return true.
 *  
 *    
 * 
 *
 */
// approach: hash set
// use hash set to record the previous seen numbers
// initialize 3 hashset list each contain 9 hash set to record the rows, cols, boxes
// use 2 nested for loop to traverse the  value in the 2d arry
// get the value in the 2d array
// if the value is .
//  continue
// if the value is in the row 
//  return false because is mean it is the second occurrence
// otherwise add the value in the rows hash set
// if the value is already in the col
//   return false
// otherwise add the value in the cols hash set
// revert the index that in the box
// if the value is already in the box
//   return false
//  otherwise add the value in the box hash set



public class ValidSudoku36 {
	
	public boolean isValidSudoku(char[][] board) {
		
		int N = 9;
		
		// use hash set to record the status
		HashSet<Character>[] rows = new HashSet[N];
		HashSet<Character>[] cols = new HashSet[N];
		HashSet<Character>[] boxes = new HashSet[N];
		
		// space O(N^2) because we need to create 3N arrays to store all previously seen numbers for all rows, cols and boxes.
		for(int r = 0; r < N; r++) {
			
			rows[r] = new HashSet<Character>();
			cols[r] = new HashSet<Character>();
			boxes[r] = new HashSet<Character>();
		}
		
		// time O(N^2) because we need to traverse every position  
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				
				char val = board[r][c];
				
				// check if the position is filled with number
				if(val == '.') {
					continue;
				}
				
				// check the row
				if(rows[r].contains(val)) {
					return false;
				}
				rows[r].add(val);
				
				// check the col
				if(cols[c].contains(val)) {
					return false;
				}
				cols[c].add(val);
				
				// check the box
				int idx = (r/3) * 3 + c / 3;
				if(boxes[idx].contains(val)) {
					return false;
				}
				boxes[idx].add(val);
			}
		}
		
		return true;
	}

}

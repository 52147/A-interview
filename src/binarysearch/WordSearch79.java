package binarysearch;
/**
 * 
 * 79. Word Search
 * 
 * - given an m * n grid of characters board and a string word,
 *   return true if word exists in the grid.
 *   
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * 
 * Approach : backtracking
 * 
 * backtracking:
 *  - we mark the current path, if path does not lead to a solution,
 *    we then revert the change and try another path
 *    
 *    
 *  at each step we mark our choice before jumping into the next step.
 *  at the end of each step, we would revert our marking,
 *  so that we could have a clean slate to try another direction.
 *  
 *  the exploration is done via the dfs, where we go as further as possible before we try the next direction.
 *  
 *  Algorithm:
 *  
 *  - The skeleton of the algorithm is a loop that iterates through each cell in the grid.
 *  - we invoke the backtracking function(backtrack()) to check if we obtain a solution
 *  
 *  - for the backtracking function backtrack(row, col, suffix),
 *    , as a dfs algorithm, it is often implemented as a recursive function.
 *  - The function can be broke down into the following steps:
 *    
 *    - step 1:
 *      -  we check if we reach the bottom case of the recursion, where the word to be matched is empty
 *    
 *    - step 2:
 *      - check if the current state is invalid, 
 *        either the position of the cell is out of the boundary of the board or the letter in the current cell does not match with the first letter of the word.
 *        
 *    - step 3:
 *      - If the current step is valid, we then start the exploration of backtracking with the strategy of DFS. 
 *      - First, we mark the current cell as visited, e.g. any non-alphabetic letter will do. 
 *      - Then we iterate through the four possible directions, namely up, right, down and left. The order of the directions can be altered, to one's preference.
 * 
 *   - step 4:
 *     - At the end of the exploration, we revert the cell back to its original state. 
 *     - Finally we return the result of the exploration.
 *
 */
public class WordSearch79 {
	
	private char[][] board;
	private int ROWS;
	private int COLS;
	
	public boolean exist(char[][] board, String word) {
		this.board = board;
		this.ROWS = board.length;
		this.COLS = board[0].length;
		
		for(int row = 0; row < this.ROWS; row++) {
			
			for(int col = 0; col < this.COLS; col++) {
				
				if(this.backtrack(row, col, word, 0)) {
					return true;
				}
				 
			}
		}
		
		return false;
	}
	
	
	protected boolean backtrack(int row, int col, String word, int index) {
		
		/*Step 1. check the bottom case*/
		if(index >= word.length()) {
			return true;
		}
		
		/*Step 2. check the boundaries*/
		if(row < 0 || row == this.ROWS || col < 0 || col == this.COLS || this.board[row][col] != word.charAt(index) ) {
			return false;
		}
		
		
		/*Step 3. explore the neighbors*/
		boolean ret = false;
		
		// mark the path before the next dfs
		this.board[row][col] = '#';
		
		int[] rowOffsets = {0, 1, 0, -1};
		int[] colOffsets = {1, 0, -1, 0};
		
		for(int d = 0; d < 4; d++) {
			ret = this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index+ 1);
			
			if(ret)
				break;
		}
		
		/*Step 4. clean up and return the result*/
		this.board[row][col] = word.charAt(index);
		
		return ret;
	}

}


/**
 * time: O(N^3) where N is the number of cells in the board and L is the length of the word to be matched.
 * 
 *  - For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 
 *    (since we won't go back to where we come from). 
 *  - As a result, the execution trace after the first step could be visualized as a 3-ary tree, 
 *    each of the branches represent a potential exploration in the corresponding direction. 
 *  - Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, 
 *    which is about 3^L
 *  - We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.
 *
 *  - As a result, overall the time complexity of the algorithm would be O(N * 3^L)
 *  
 * Space Complexity: O(L) where L is the length of the word to be matched.
 * 
 *  - The main consumption of the memory lies in the recursion call of the backtracking function. 
 *  - The maximum length of the call stack would be the length of the word. 
 *  - Therefore, the space complexity of the algorithm is O(L).


L
 .
 */

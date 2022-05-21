package vo;
/**
 * 
 * 64. Minimum Path Sum
 * 
 * - Given a m*n grid filled with non-negative numbers,
 *   find a path from top left to bottom right,
 *   which minimizes the sum of all numbers along its path.
 *   
 * - Note: You can only move either down or right at any point in time.
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * 
 *  Approach : DP 2d
 *  
 *  Algorithm:
 *  
 * - We use an extra matrix dp of the same size as the original matrix. In this matrix, dp(i, j) represents the minimum sum of the path from the index (i, j) to the bottom rightmost element. 
 * - We start by initializing the bottom rightmost element of dp as the last element of the given matrix. 
 * - Then for each element starting from the bottom right, we traverse backwards and fill in the matrix with the required minimum sums. Now, we need to note that at every element, we can move either rightwards or downwards. Therefore, for filling in the minimum sum, we use the equation:
 *
 * - dp(i,j)=grid(i,j)+min(dp(i+1,j),dp(i,j+1))
 *
 * - taking care of the boundary conditions.
 *
 * - The following figure illustrates the process:
 *
 */
public class MinimumPathSum64 {
	
	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		
		for(int i = grid.length - 1; i >= 0; i--) {
			for(int j = grid[0].length - 1; j >= 0; j--) {
				
				if(i == grid.length - 1 && j != grid[0].length - 1) {
					dp[i][j] = grid[i][j] + dp[i][j + 1];
				}else if(j == grid[0].length - 1 && i != grid.length - 1) {
					dp[i][j] = grid[i][j] + dp[i + 1][j];
				}else if(j != grid[0].length - 1 && i != grid.length - 1) {
					dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
				}else {
					dp[i][j] = grid[i][j];
				}
			}
		}
		
		return dp[0][0];
	}

}
/**
 * Time complexity : O(mn). We traverse the entire matrix once.
 * 
 * Space complexity : O(mn). Another matrix of the same size is used.
 */



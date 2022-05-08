package fall;
/**
 * 
 * You are given a black & white image in form of m*n pixel matrix grid.

if pixel[i][j] = 0 then pixel is black
if pixel[i][j] = 1 then pixel is white
Calculate maximum greyness of image.
Where greyness of a pixel[i][j] = (number of 1s in ith row + number of 1s in jth column) - (number of 0s in ith row + number of 0s in jth column)

My Aproach:

Calculated the total number of 1s in each row and each column (row_1s array and col_1s array) using simple prefix array
number of 0s in a row = m - number of 1s
let number of 1s in ith row is x and number of 1s in jth colum is y then number of 0s in ith row = m - x and number of 0s in jth column = n - y
greyness = (x + y) - (m - x + n - y) = 2*(x + y) - (m + n)
used nested for loops to iterate over all pixels and checked for the maximum greyness overall.
Time Complexity: O(m*n)
Space Complexity: O(n)
 *
 */


public class Greyness {
	
	public int getMaximumGrey(int[][] grid) {
		int[] row = new int[grid.length];
		int[] col = new int[grid[0].length];;
		
		for(int i = 0; i < grid.length; i++) {
			
			for(int j = 0; j < grid[0].length; j++) {
				
				if(grid[i][j] == 1 ) {
					row[i] += 1;
					col[j] += 1;
				}else {
					row[i] -= 1;
					col[j] -=1;
				}
			}
		}
		
		int max = row[0];
		for(int i = 0; i < row.length; i++) {
			if(row[i] > max) {
				max = row[i];
			}
		}
		int max2 = col[0];
		for(int i = 0; i < col.length; i++) {
			if(col[i] > max) {
				max2 = col[i];
			}
		}
		
		
		return max + max2;
	}

}

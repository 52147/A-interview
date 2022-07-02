package vo;
/**
 * 
 * 11. Container With Most Water
 * 
 * - You are given an integer array height of length n.
 * - There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i)
 * - Return the maximum amount of water a container can store.
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * 
 * 
 * Approach : Two Pointer Approach
 * 
 * Algorithm :
 * 
 * - The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line.
 * - Further, the farther the lines, the more will be the area obtained.
 * 
 * - We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
 * - Further, we maintain a variable maxarea to store the maximum area obtained till now.
 * - At every step, we find out the area formed between them, update maxarea and move the pointer pointing to the shorter line towards the other end by one step.
 * 
 * 
 * - Initially we consider the area constituting the exterior most lines.
 * - Now, to maximize the area, we need to consider the area between the lines of larger lengths.
 * - If we try to move the pointer at the longer line inwards,
 *   we won't gain any increase in area, since it is limited by the shorter line.
 * - But moving the shorter line's pointers could turn out to be beneficial, as per the same argument, despite the reduction in the width.
 * - This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.
 * 
 */
public class ContainerWithMostWater11 {
	
	public int maxArea(int[] height) {
		int maxarea = 0;
		int left = 0;
		int right = height.length - 1;
		
		while(left < right) {
			int width = right - left;
			
			maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
			if(height[left] <= height[right]) {
				left++;
			}else {
				right--;
			}
		}
		
		return maxarea;
	}

}

/**
 * time : O(n). single pass
 * space: O(1). constant space is used.
 * 
 */



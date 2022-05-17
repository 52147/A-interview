package vo;
/**
 * 
 * 104. Maximum Depth Of Binary Tree
 * 
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * 
 * 
 * Approach : Recursion
 * 
 * the maximum depth of a binary tree is the maximum number of steps to reach a leaf node from the root node.
 * 
 * to traverse the tree and record the maximum depth during the traversal
 * 
 * One could traverse the tree either by Depth-first search (dfs) or Breadth-first search (bfs)
 * 
 * 
 *
 */
public class MaximumDepthOfBinaryTree104 {
	
	public int maxDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}else {
			int left_height = maxDepth(root.left);
			int right_height = maxDepth(root.right);
			
			return java.lang.Math.max(left_height, right_height) + 1;
		}
	}

}

/**
 * time: O(N)
 * we visit each node exactly once, thus the time complexity is O(N), where N is the number of nodes.
 * 
 * Space:
 * - in the worst case, the tree is completely unbalanced,
 *   e.g. each node has only left child node, 
 *   the recursion call would occur N times(the height of the tree),
 *   therefore the storage to keep the call stack would be O(N).
 *   
 * - But in the best case(the tree is completely balanced),
 *   the height of the tree would be log(N).
 * - Therefore, the space complexity in this case would be O(loi)
 */




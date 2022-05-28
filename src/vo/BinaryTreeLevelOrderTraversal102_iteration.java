package vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * 102. Binary Tree Level Order Traversal
 * 
 * Approach: iteration
 * 
 * - keep nodes of each level in the queue structure, which orders elements in a first-in-first-out manner.
 * - In Java one could use LinkedList implementation of the queue interface.
 * 
 * - The zero level contains only one node root.
 * - The algorithm is simple:
 *   1. Initiate queue with a root and start from the level number 0: level = 0
 *   2. While queue is not empty:
 *      - Start the current level by adding an empty list into output structure levels.
 *      - Compute how many elements should be on the current level:
 *        - it's a queue length.
 *      - pop out all these elements from the queue and add them into the current level.
 *      - push their child nodes into the queue for the next level.
 *      - go to the next level++
 * 
 * 1. 
 * 
 *
 */
public class BinaryTreeLevelOrderTraversal102_iteration {
	
	public List<List<Integer>> levelOrder(TreeNode root){
		
		List<List<Integer>> levels = new ArrayList<>();
		
		if(root == null) {
			return levels;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		int level = 0;
		
		while(!queue.isEmpty()) {
			// start the current level
			levels.add(new ArrayList<Integer>());
			
			// number of elements in the current level
			int level_length = queue.size();
			for(int i = 0; i < level_length; i++) {
				TreeNode node= queue.remove();
				
				// fulfill the current level
				levels.get(level).add(node.val);
				
				// add child node of the current level
				// in the queue for the next level
				if(node.left != null) {
					queue.add(node.left);
				}
				
				if(node.right != null) {
					queue.add(node.right);
				}
				
				
			}
			// go to the next level
			level++;
			
			
		}
		
		return levels;
	}

}

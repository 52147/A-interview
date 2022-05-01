package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 145. Binary Tree PostOrder Traversal
 * 
 *     1
 *    /\
 *    2 3
 *   /\ /\
 *  4 5 6 7
 *  
 *  
 *  postorder:  4 -> 5 -> 2 -> 6 -> 7 -> 3 -> 1
 *  
 *  
 *  Approach: dfs + backtracking
 *  
 *  0. Initialize dfs method use root node and a list to contain the postorder values
 *  1.   
 *  
 *  - use dfs method to call the dfs root.right and dfs root.left and add root value in list
 *  - stop condition : root = null
 *  
 *  -----------------------------
 *  
 *                   dfs(root) 1
 *                 /          \
 *    dfs(root.left)2        dfs(root.right) add root3
 *     /          \                      /      \
 * dfs(root.left)4 dfs(root.right)5 dfs(root.left)6 dfs(root.right)7 
 *    /\
 *  root.left = null -> stop ->
 *  
 *   add 4 -> add 5 -> add 2 -> add 6 -> add 7 -> add 3 -> add 1
 *  
 *
 */

// time: O(N) use dfs call number of n node(n: total node in tree)
public class BinaryTreePostorderTraversal145 {
	
	
	public List<Integer> postorderTraversal(TreeNode root){
		
		// create a list to put the order result in
		List<Integer> list = new ArrayList<>();
		
		// call the first dfs with root node
		dfs(root, list);
		
		return list;
	}
	
	void dfs(TreeNode root, List<Integer> list) {
		
		if(root != null) {
		// call the dfs use root.left
		dfs(root.left, list);
		
		// call the dfs use root.right
		dfs(root.right, list);
		
		// backtrack to add node value
		list.add(root.val);
		
		
		}
		
	}

}

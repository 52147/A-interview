package vo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * 98. Validate Binary Search Tree
 * 
 * Approach : iterative inorder traversal
 * 
 *
 */
public class ValidateBinarySearchTree98_iterative {
	
	public boolean isValidBST(TreeNode root) {
		
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		Integer prev = null;
		
		while(!stack.isEmpty() || root != null) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			// if next element in inorder traversal
			// is smaller than the previous one
			// that is not BST
			if(prev != null && root.val <= prev) {
				return false;
			}
			
			prev = root.val;
			root = root.right;
			
			
			
		}
		
		return true;
	}

}
/**
 * time: O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.
 * space : O(N) to keep stack.
 */



package vo;
/**
 * 
 * 236. Lowest Common Ancestor Of a BinaryTree
 * 
 * - Given a binary tree, find the lowest common ancestor(LCA) of two given nodes in the tree.
 * - LCA:
 *   - The lowest common ancestor is defined between 2 nodes p and q as the lowest node in T 
 *     that has both p and q as descendants(where we allow a node to be a descendant of itself).
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Approach : recursion
 * 
 * Algorithm:
 * 
 * 1. Start traversing the tree from the root node.
 * 2. If the current node itself is one of p or q, 
 *    we would mark a variable mid as True
 *    and continue the search for the other node in the left and right branches.
 *    
 * 3. If either of the left or the right branch returns True, 
 *    this means one of the two nodes was found below.
 *    
 * 4. If at any point in the traversal, any two of the three flags left, right or mid
 *    become True,
 *    this means we have found the lowest common ancestor for the nodes p and q.
 *
 */
public class LowestCommonAncestorOfABinaryTree236 {
	
	private TreeNode ans;
	
	public LowestCommonAncestorOfABinaryTree236() {
		// variable to store LCA node
		this.ans = null;
	}
	
	private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
		
		// If reached the end of a branch, return false.
		if(currentNode == null) {
			return false;
		}
		
		// left recursion.
		// if left recursion returns true, set left = 1 else 0
		int left = this.recurseTree(currentNode.left, p, q) ? 1: 0;
		
		// right recursion
		int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
		
		// if the current node is one of p or q
		int mid = (currentNode == p || currentNode == q) ? 1 : 0;
		
		// if any two of the flags left, right or mid become True
		if(mid + left + right >= 2) {
			this.ans = currentNode;
		}
		
		// return true if any one of the three bool values is True
		return (mid + left + right > 0);
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		// traverse the tree
		this.recurseTree(root, p, q);
		
		return this.ans;
	}

}
/**
 * time: O(N), 
 * - where N is the number of nodes in the binary tree.
 * - In the worst case we might be visiting all the nodes of the binary tree.
 * 
 * space: O(N).
 * - This is because the maximum amount of space utilized by the recursion stack would be N
 *   since the height of a skewed binary tree could be N.
 */



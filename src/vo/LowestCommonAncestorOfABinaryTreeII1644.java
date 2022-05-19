package vo;
/**
 * 
 * 1644. Lowest Common Ancestor Of a binary Tree ll
 * 
 * - Given the root of a binary tree, return the lowest common ancestor(LCA) of two given nodes, p and q.
 * - If either node p or q does not exist in the tree, return null.
 * - All values of the node in the nodes in the tree are unique.
 *        
 * LCA: 
 * - The lowest common ancestor of two nodes p an q in a binary tree T is the lowest node that has both p and q as descendants
 *   (where we allow a node to be a descendant of itself).
 * - A descendant of a node x is a node y that is on the path from node x to some leaf node.
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * Solution 1: Use 2 booleans
 * This question is similar to 236. Last Common Ancestor of Binary Tree. Question 236 has two important premises:
 * 
 * It is guaranteed that both p and q are in the tree.
 * A node can be a descendant of itself.
 * But for this question, the premises are different:
 *
 * It is NOT guaranteed that both p and q are in the tree.
 * A node can still be a descendant of itself.
 * Hence,
 *
 * We need a way to record if we've seen both p and q
 * We need to traverse the entire tree even after we've found one of them.
 * Here are the differences in code. The rest is the same.
 *
 * Use either boolean or integers as flags
 * Keep traversing down the entire tree. If you return early, the above example would be null, because the code stops when it finds 5 and does not keep searching for 4.
 * 
 *
 */
public class LowestCommonAncestorOfABinaryTreeII1644 {
	
	boolean pFound = false;
	boolean qFound = false;
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode LCA = LCA(root, p, q);
		return pFound && qFound ? LCA : null;
	}
	
	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null) {
			return root;
		}
		
		TreeNode left = LCA(root.left, p, q);
		TreeNode right = LCA(root.right, p, q);
		
		if(root == p) {
			pFound = true;
			return root;
		}
		
		if(root == q) {
			qFound = true;
			return root;
		}
		
		return left == null ? right : right == null ? left : root;
	}

}
/**
 * Time Complexity: O(N)
 * Space Complexity: O(H), H is the height of the tree
 */





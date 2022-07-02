package vo;

import java.util.Map;

/**
 * 
 * 105. Construct Binary Tree From Preorder and Inorder Traversal
 * 
 * - Given two Integer arrays preorder and inorder where preorder 
 *   is the preorder traversal of a binary tree and inorder traversal of the same tree, 
 *   construct and return the binary tree.
 *   
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 
 * Approach : Recursion
 * 
 * Intuition:
 * 
 * - The two key observations are:
 *   
 *   - 1. Preoder traversal follows root -> left -> right,
 *        therefore, given the preoder array preorder,
 *        we have easy access to the root which is preorder[0].
 *   - 2. Inorder traversal follows left -> root -> right, 
 *        therefore if we know the position of root, 
 *        we can recursively split the entire array into two subtrees.
 *        
 * - Now the idea should be clear enough.
 * - We will design a recursion function:
 *   - it will set the first element of preorder as the root,
 *     and then construct the entire tree.
 *   - To find the left and right subtrees, it will look for the root in inorder,
 *     so that everything on the left should be the left subtree,
 *     and everything on the right should be the right subtree.
 *   - Both subtrees can be constructed by making another recursion call.
 *   
 * - It is worth nothing that, while we recursively construct the subtrees.
 *   we should choose the next element in preorder to initialize as the new roots.
 * - This is because the current one has already been initialize to a parent node fot the subtrees.
 * 
 * 
 * Algorithm:
 * 
 * - Build a hashmap to record the relation of value -> index for inorder,
 *   so that we can find the position of the root in constant time.
 * - Initialize an integer variable preorderIndex to keep track of the element
 * - Implement the recursion function arrayToTree which takes a range of inorder
 *   and returns the constructed binary tree:
 *   - if the range is empty, return null.
 *   - initialize the root with preorder[preorderIndex] and then increment preorderIndex.
 *   - recursively use the left and right portions of inorder to construct the left and right subtrees.
 * 
 * - Simply call the recursion function with the entire range of inorder.
 *       
 *   
 *        
 *         
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
	
	int preorderIndex;
	Map<Integer, Integer> inorderIndexMap;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		
		preorderIndex = 0;
		// build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();

		for(int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}
		
		return arrayToTree(preorder, 0, preorder.length - 1);
	}
	
	private TreeNode arrayToTree(int[] preorder, int left, int right) {
		// if there are no elements to construct the tree
		if(left > right) {
			return null;
		}
		
		// Select the preorder_ index element as the root and increment it
		int rootValue = preorder[preorderIndex++];
		TreeNode root = new TreeNode(rootValue);
		
		// build left and right subtree
		// excluding inorderIndexMap[rootVlaue] element because it's the root
		root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue)- 1);
		root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
		
		return root;
		
		
		
		
	}

}

/**
 * Let N the length of the input arrays.
 * 
 * - Time: O(N)
 * 
 * Building the hashMap takes O(N) time, as ther are N nodes to add, 
 * and adding items to a hashMap has a cost of O(1),
 * so we get N O(1) = (N)
 * 
 * Building the tree also takes O(N) times.
 * The recursive helper method has a cost of O(1) for each call (it has no loops),
 * and it is called once for each of the N nodes, giving a total of O(N)
 * 
 * 
 * space: O(N)
 * - Building the hashmap and storing the entire tree each requires O(N) memory. 
 * - The size of the implicit system stack used by recursion calls depends on the height of the tree, which is O(N) in the worst case and O(logN) on average. 
 * - Taking both into consideration, the space complexity is O(N).
 * 
 * 
 */



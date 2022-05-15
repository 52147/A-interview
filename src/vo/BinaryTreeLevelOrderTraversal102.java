package vo;

import java.util.ArrayList;
import java.util.List;
/**
 * 102. level order traversal 
 * 
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 * 
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * 
 * Input: root = []
 * Output: []
 *
 */

// 102. level order traversal (approach recursion)
//output: each layer a list , and all layer in the big list
//=> use List<List<Integer>>

// recursion method:
//level order => use recursion  => bfs()
//need to know whether in the same level 
//=> need a parameter to  mark the level
//if same level => new a array list for this level's node => add node to the list => how to add the same level node in the same list => use the list size => each size represent the same level
// base case:  if the node left or node right == null
//if not keep call the left and right node

// driver method (a method to call the bfs):
// initial call the bfs with root node and 0 (0 level is equal to the list size, so we can add a new array list in the list)
// another condition is Input: root = [], we need to output the [] empty list
// => so add a if statement to check whether the root is empty 
// => is is empty, directly return the arraylist (empty list)


class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(){}
	
	TreeNode(int val){
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
}

// time: O(N) each node process one
// space: O(N) arraylist(output structure) contains n nodes
public class BinaryTreeLevelOrderTraversal102 {
	
	// out put format:
	List<List<Integer>> levels = new ArrayList<>();
	
	// recursion to level order traverse the tree node / stop condition : root left and root right == null
	public void bfs(TreeNode root, int level) {
		
		// the list property:  add each level node => list size == level of node => start with size 0
		if(levels.size() == level) {
			levels.add(new ArrayList<>());
		}
		
		 
		
		
		if(root.left != null) {
			bfs(root.left, level + 1);
		}
		
		if(root.right != null) {
			bfs(root.right, level + 1);
		}
		
	}
	
	
	public List<List<Integer>> levelOrder(TreeNode root){
		
		// need to check root is null before the bfs function
		// because if root is null we will get the nullpointerexception at " levels.get(level).add(root.val); "
		if(root == null) {return levels;} // return [] empty arraylist
		
		
		bfs(root, 0); // start with level 0 because the list size is 0	
	
		
		return levels;
	}
	
	

}

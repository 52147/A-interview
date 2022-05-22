package vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * 
 * DFS (Depth-First Search)
 * 
 * Algorithm:
 * 
 *  - Here we implement the DFS algorithm via recursion.
 *  - We define a recursive function called DFS(node, level)
 *    which only takes care of the current node 
 *    which is located at the specified level.
 *   
 *    - If this is the first time that we visit any node at the level,
 *      i.e. the deque for the level does not exist,
 *      then we simply create the deque with the current node value
 *      as the initial element.
 *      
 *    - If the deque for this level exists, then depending on the ordering
 *      , we insert the current node value either to the head or to the tail of the queue.
 *      
 *    - At the end, we recursively call the function for each of its child nodes.
 *    
 * 
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal103_BFS {
	
	protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
		
		
		 if (level >= results.size()) {
		      LinkedList<Integer> newLevel = new LinkedList<Integer>();
		      newLevel.add(node.val);
		      results.add(newLevel);
		    } else {
		      if (level % 2 == 0)
		        results.get(level).add(node.val);
		      else
		        results.get(level).add(0, node.val);
		    }

		    if (node.left != null) DFS(node.left, level + 1, results);
		    if (node.right != null) DFS(node.right, level + 1, results);
		  }

		  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		    if (root == null) {
		      return new ArrayList<List<Integer>>();
		    }
		    List<List<Integer>> results = new ArrayList<List<Integer>>();
		    DFS(root, 0, results);
		    return results;
		  }

}

/**
 * Time Complexity: O(N), 
 * - where N is the number of nodes in the tree.
 * - Same as the previous BFS approach, we visit each node once and only once.
 * 
 * Space Complexity: O(H), 
 * - where H is the height of the tree, 
 * - i.e. the number of levels in the tree, which would be roughly log2N.
 * - Unlike the BFS approach, in the DFS approach, 
 * - we do not need to maintain the node_queue data structure for the traversal.
 * 
 * - However, the function recursion would incur additional memory consumption on the function call stack. 
 * - As we can see, the size of the call stack for any invocation of DFS(node, level) would be exactly the number of level that the current node resides on. 
 * - Therefore, the space complexity of our DFS algorithm is O(log 2  N) which is much better than the BFS approach.
 * 
 */



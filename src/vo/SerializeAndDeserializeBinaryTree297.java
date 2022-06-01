package vo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 297. Serialize and Deserialize Binary Tree
 * 
 * - Serialization is the process of converting a data structure or object into a sequence of bits 
 *   so that it can be stored in a file or memory buffer,
 *   or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * 
 * - need to ensure that a binary tree can be serialized to a string 
 *   and this string can be deserialized to the original tree structure.
 * 
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * 
 * Approach : DFS
 * 
 * - The serialization of a binary search tree is essentially to encode its values
 *   and more importantly its structure.
 * - One can traverse the tree to accomplish the above task.
 * - And it is well know that we have two general strategies to do so:
 * 
 *   - BFS:
 *     - We scan through the tree level by level,
 *       following the order of height, from top to bottom.
 *     - The nodes on higher level would be visited before the ones with lower levels.
 *     
 *   - DFS:
 *     - we adopt the depth as the priority, 
 *       so that one would start from a root and reach all the way down to certain leaf,
 *       and then back to root to reach another branch.
 *       
 *     - The dfs strategy can further be distinguished as preorder, inorder, and postorder
 *       depending on the relative order among the root node, left node and right node.
 *       
 * - The dfs is more adapted for our needs,
 *   since the linkage among the adjacent nodes is naturally encoded in the order,
 *   which is rather helpful for the later task of deserialization.
 * 
 * - In this solution, we demonstrate an example with the preorder DFS strategy.
 * 
 * Algorithm:
 * 
 * - The preorder dfs traverse follow recursively the order of
 *   root -> left subtree -> right subtree
 *   
 * - serialization contains information about the node values and the information about the tree structure.
 * - We start from the root, node 1, the serialization string is 1.
 * - Then we jump to its left subtree with the root node 2, 
 *   and the serialization string becomes 1,2,.
 * - Now starting from node 2, we visit its left node 3 (1, 2, 3 , None, None,)
 *   and right node 4.
 * - (1, 2, 3, None, None, 4, None, None) sequentially.
 * - Note that None, None, appears for each leaf to mark the absence of left and right child node,
 *   this is how we save the tree structure during the serialization.
 * - And finally, we get back to the root node 1
 *   and visit its right subtree which happens to be as leaf node 5.
 * - Finally, the serialization string is done as
 *   1, 2, 3, None, None, 4, None, None, 5, None, None
 *     
 *     
 *   
 */
public class SerializeAndDeserializeBinaryTree297 {
	
	public String reserialize(TreeNode root, String str) {
		// recursive serialization
		if(root == null) {
			str += "null,";
			
		}else {
			str += str.valueOf(root.val) + ",";
			str = reserialize(root.left, str);
			str = reserialize(root.right, str);
		}
		
		return str;
	}
	
	// encodes a tree to s single string
	public String serialize(TreeNode root) {
		return reserialize(root, "");
	}
	
	
	// now let's deserialize the serialization string constructed above
	// 1, 2, 3, None, 4, None, None, 5, None, None,.
	// It goes along the string, 
	// initiate the node value and then calls itself to construct its left and right child nodes.
	public TreeNode rdeserialize(List<String> l) {
		// recursive deserialization
		if(l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}
		
	    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = rdeserialize(l);
		root.right = rdeserialize(l);
		
		return root;
	}
	
	// decodes your encoded data to tree
	public TreeNode deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		
		return rdeserialize(data_list);
	}
	

}
/**
 * time: 
 * - in both serialization and deserialization function,
 *   we visit each node exactly once, 
 *   thus the time is O(N),
 *   where N is the number of nodes, i.r. the size of tree.
 *   
 * space:
 * - in both serialization and deserialization functions,
 *   we keep the entire tree,
 *   either at the beginning or at the end,
 *   therefore, the space is O(N).
 *   
 * - the solution with bfs or other dfs strategies normally
 *   will have the same time and space complexity.
 *   
 */






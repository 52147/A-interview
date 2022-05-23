package vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 103. Binary Tree Zigzag Level Order Traversal
 * 
 * - Given the root of a binary tree,
 *   return the zigzag level order traversal of its nodes's values.
 *   
 *   Input: root = [3,9,20,null,null,15,7]
 *   Output: [[3],[20,9],[15,7]]
 *   
 * Approach: BFS
 * 
 * - implement bfs with a single loop.
 * - the trick is that we append the nodes be visited into a queue
 *   and we separate nodes of different levels with a sort of delimiter (e.g. an empty node).
 * - The delimiter marks the end of a level, as well as the beginning of a new level.
 * 
 * - For each level, we start from an empty deque container to hold all the values of the same level.
 * - Depending on the ordering of each level, i.e. either from-left-to-right or from-right-to-left,
 *   we decide at which end of the deque to add the new element.
 *   
 *   
 *   - For the ordering of from-left-to-right(FIFO),
 *     we append the new element to the tail of the queue, 
 *     so that the element that comes late would get out late as well.
 *   - given an input sequence of [1, 2, 3, 4, 5], with FIFO ordering, 
 *     we would have an output sequence of [1, 2, 3, 4, 5].
 *     
 *   - For the ordering of from-right-to-left(FILO),
 *     we insert the new element to the head of the queue,
 *     so that the element that comes late would get out first.
 *   - With the same input sequence of [1,2, 3, 4, 5],
 *     with FILO ordering,
 *     we would obtain an output sequence of [5, 4, 3, 2, 1].
 * 
 *  
 *
 *
 */

// 103. binary tree zigzag level order traversal
// if root == null return the empty arraylist
// create a arraylist to store the output
// create a linked list to the store the tree node that traverse
// add the root node and null node(delimiter)
// create a linked list to process the left order or right order node
// a while loop to traverse the node
// poll the first node that need to go
// if the node is not null (not the end of the level)
//   if the boolean parameter is true(mean need to add from left)
//     add node value from last
//   if not
//     add node value form first
//   (add the left and right child)
//   if left child is not null
//     add it in the queue
//   if right child is not null
//      add it in the queue
// else(if encounter the null node which means is the end of the level)
//   add the level(linkedlis) in the result array list
// new a empty list to the level
// if the queue has the node(means there is left and right child)
//    add the null node at the last 
// set the boolean parameter to the opposite
// end the while loop
// return the result arraylist


public class BinaryTreeZigazgLevelOrderTraversal103 {
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
		
		if(root == null) {
			return new ArrayList<List<Integer>>();
		}
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		// add the root element with delimiter to kick off the bfs loop
		LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
		node_queue.addLast(root);
		node_queue.addLast(null);
		
		LinkedList<Integer> level_list = new LinkedList<Integer>();
		boolean is_order_left = true;
		
		while(node_queue.size() > 0) {
			
			TreeNode curr_node = node_queue.pollFirst();
			
			if(curr_node != null) {
				if(is_order_left)
					level_list.addLast(curr_node.val);
				else
					level_list.addFirst(curr_node.val);
				
				if(curr_node.left != null)
					node_queue.addLast(curr_node.left);
				if(curr_node.right != null)
					node_queue.addLast(curr_node.right);
			}else {
				
				// we finish the scan of one level
				results.add(level_list);
				level_list = new LinkedList<Integer>();
				
				// prepare for the next level
				if(node_queue.size() > 0) {
					node_queue.addLast(null);
				is_order_left =! is_order_left;
				}
			}
		}
		
		return results;
	}

}

/**
 * Time Complexity: O(N), where NN is the number of nodes in the tree.
 * 
 * - We visit each node once and only once.
 * - In addition, the insertion operation on either end of the deque takes a constant time, rather than using the array/list data structure where the inserting at the head could take the O(K) time where K is the length of the list.
 * 
 * Space Complexity: O(N) where N is the number of nodes in the tree.
 * 
 * - The main memory consumption of the algorithm is the node_queue that we use for the loop, apart from the array that we use to keep the final output.
 * 
 * - As one can see, at any given moment, the node_queue would hold the nodes that are at most across two levels. Therefore, at most, the size of the queue would be no more than 2⋅L, assuming L is the maximum number of nodes that might reside on the same level. 
 * - Since we have a binary tree, the level that contains the most nodes could occur to consist all the leave nodes in a full binary tree, which is roughly L = N/2 
 * 
 * - As a result, we have the space complexity of 2* N/2 = N
 *   in the worst case.
 */



package vo;
// 133 Clone Graph
// given a reference of a node in a connected undirected graph.
// return a deep copy
// deep copy: rather than references to objects being copied, new copy objects are created for any referenced objects
// approach : dfs
// algorithm:
// 1. start traversing the graph from the given node
// 2. take a hash map to store the reference of the copy of all nodes that have already been visited and cloned.
// the key of the hashmap would be the node of the original graph
// and value would be the cloned node of the cloned graph
// if the node already exists in the visited we return stored reference of the cloned node

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// for a given edge A-B, since A is connected to B and B is also connected to A
// if we don't used visited we will get stuck in a cycle

// 3. if we don't find the node in the visited hash map, 
//    we create a copy of it and put it in the hash map

// note, it is important to create a copy of the node and add to the hash map before entering recursion.
// in the absence of such an ordering, 
// we would be caught in the recursion because on encountering the node again in somewhere down the recursion again,
// we will be traversing it again thus getting into cycles

// 4. Now make the recursive call for the neighbors of the nodes.
// for given node the number of recursive calls would be equal to the number of its neighbors.
// each recursive call made would return the clone of a neighbor
// we will prepare the list of these clones returned and put into neighbors of clone node 
// This way we will have cloned the given node and it's neighbors.

// definition for a node.
class Node{
	public int val;
	public List<Node> neighbors;
	
	public Node() {}
	
	public Node(int _val, List<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
public class CloneGraph133 {
	
	private HashMap<Node, Node> visited = new HashMap<>();
	
	public Node cloneGraph(Node node) {
		if(node == null) {
			return node;
		}
		
		// if the node was already visited before.
		// return the clone from the visited dictionary.
		if(visited.containsKey(node)) {
			return visited.get(node);
		}
		
		// create a clone for the given node.
		// Note that we don't have cloned neighbors as of now, here [].
		Node cloneNode = new Node(node.val, new ArrayList<>());
		
		// The key is original node and value being the clone node.
		visited.put(node, cloneNode);
		
		// Iterate through the neighbors to generate their clones.
		// and prepare a list of cloned neighbors to be added to the cloned node.
		for(Node neighbor: node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(neighbor));
		}
		
		return cloneNode;
		
	}

}
/**
 * time: O(N + M) where N is a number of nodes and M is a number of edges
 * 
 * space: O(N). 
 * - This space is occupied by the visited hashmap
 * - and also be occupied by the recursion stack 
 *   - the space occupied by the recursion stack would be equal to O(H) where H is the height of the graph.
 * - Overall, the space would be O(N)
 * 
 */



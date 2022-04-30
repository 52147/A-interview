package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 210. Course Schedule II
 * 
 * total of numCourses courses you have to take
 * 
 * an array prerequisites where
 * 
 *  prerequisites[i] = [ai, bi]
 *  indicates that you must take course bi first if you want to take course ai
 *  
 *  return the ordering of courses you should take to finish all courses.
 * 
 * Approach : dfs
 * 
 * [a, b] represents that the course b needs to be taken to do the course a
 * 
 * this implies an edge of the form b -> a
 *
 */

public class CourseScheduleII210 {
	
	static int WHITE = 1;
	static int GRAY = 2; // grey nodes depict ongoing recursion
	static int BLACK = 3; // once the recursion finishes, mark the node Black
	
	boolean isPossible;
	Map<Integer, Integer> color;
	Map<Integer, List<Integer>> adjList;
	
	List<Integer> topologicalOrder;
	
	private void init(int numCourses) {
		
		this.isPossible = true; // true mean no cycle
		this.color = new HashMap<>();
		this.adjList = new HashMap<>();
		this.topologicalOrder = new ArrayList<>();
		
		// by default all vertces are WHITE
		for(int i = 0; i < numCourses; i++) {
			this.color.put(i, WHITE);
		}
	}
	
	
	private void dfs(int node) {
		
		// Don't recurse further if we found a cycle already
		if(!this.isPossible) {
			return;
		}
		
		// start the recursion
		this.color.put(node, GRAY);
		
	   // Traverse on neighboring vertices
	   for(Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
		   
		   if(this.color.get(neighbor) == WHITE) {
			   this.dfs(neighbor);
			   
		   }else if(this.color.get(neighbor) == GRAY){
			   // an edge to a gray vertex represents a cycle
			   this.isPossible = false;
		   }
	   }
	   
	   // Recursion end. we mark it as black
	   this.color.put(node, BLACK);
	   this.topologicalOrder.add(node);
		
		
	}
	
	
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		this.init(numCourses);
		
		// create the adjacency list representation of the graph
		for(int i = 0; i < prerequisites.length; i++) {
			
			int dest = prerequisites[i][0];
			int src = prerequisites[i][1];
			// [a, b]   b -> a
			List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
			
			
			lst.add(dest);
			adjList.put(src, lst);
		}
			// if the node is unprocessed, then call dfs on it.
			for(int i = 0; i < numCourses; i++) {
				
				if(this.color.get(i) == WHITE) {
					this.dfs(i);
				}
			}
			
			
			int[] order;
			
			if(this.isPossible) {
				
				order = new int[numCourses];
				
				for(int i = 0; i < numCourses; i++) {
					
					order[i] = this.topologicalOrder.get(numCourses - i - 1);
				}
			}else {
				order = new int[0];
			}
			
			return order;
			
			
		}
	
	
}
/**
 * Time : O(V + E)
 * 
 *  - V represents the number of vertices and E represents the number of edges.
 *  - we iterate through each node and each vertex in the graph once
 *  
 * Space: O(V + E)
 * 
 *  - we use the adjacency list to represent our graph initially.
 *  - The space occupied is defined by the number of edges because
 *    for each node as the key,
 *    we have all its adjacent nodes in the form of a list as the value.
 *  - Hence, O(E)
 *  
 *  - Additionally, we apply recursion, which in worst case will incur O(E)
 *    extra space in the function call stack.
 *    
 *  - To sum up, the overall space complexity is O(V + E)
 *    
 *  
 */




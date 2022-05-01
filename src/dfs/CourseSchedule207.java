package dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 207. Course Schedule
 * 
 * numCorse: the total number of course you have to take
 * array prerequisites : prerequisites[i] = [ai, bi] indicate that you must take course bi first if you want to take course ai
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * 
 * Approach: postorder DFS 
 * 
 * 1. build a graph from prerequisites
 * 
 * 2. We then enumerate each node in the graph to check if there is a cycle
 * 
 * 3. check if the current node has been checked before,
 *    otherwise we enumerate through its child nodes via backtracking.
 *    
 *    mark the nodes we visited to detect if we come across a previously visited node (hence a cycle detected). 
 *    We also remove the breadcrumbs for each iteration.
 *    
 *    once we use post order visited all the child node, we marked the current node as checked.
 *
 */

public class CourseSchedule207 {
	
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		
		// course -> list of next courses
		HashMap<Integer, List<Integer>> courseDict = new HashMap<>();
		
		// build the graph first
		for(int[] relation : prerequisites) {
			
			// relation[0] depends on relation[1]
			if(courseDict.containsKey(relation[1])) {
				courseDict.get(relation[1]).add(relation[0]);
			}else {
				List<Integer> nextCourses = new LinkedList<>();
				
				nextCourses.add(relation[0]);
				
				courseDict.put(relation[1], nextCourses);	
				
			}
		}
		
		boolean[] checked = new boolean[numCourses];
		boolean[] path = new boolean[numCourses];
		
		for(int currCourse = 0; currCourse < numCourses; currCourse++) {
			if(this.isCyclic(currCourse, courseDict, checked, path)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	// post order dfs check that no cyclic would be formed starting from currCourse
	protected boolean isCyclic(Integer currCourse, HashMap<Integer, List<Integer>> courseDict, boolean[] checked, boolean[] path) {
		
		
		// bottom cases
		if(checked[currCourse]) {
			// this node has been checked, no cycle would be formed with this node.
			return false;
		}
		
		if(path[currCourse]) {
			// come across a previous visited node, i.e. detect the cycle
			return true;
		}
		
		// no following courses, no loop
		if(!courseDict.containsKey(currCourse)) {
			return false;
		}
		
		
		// before backtracking, mark the node in the path
		path[currCourse] = true;
		
		boolean ret = false;
		
		// postorder dfs to visit all its children first.
		for(Integer child : courseDict.get(currCourse)) {
			ret = this.isCyclic(child, courseDict, checked, path);
			if(ret)
				break;
		}
		
		// after the visits of children, we come back to process the node itself
		// remove the node from the path
		path[currCourse] = false;
		
		// Now that we've visited the nodes in the downstream,
		// we complete the check of this node.
		checked[currCourse] = true;
		
		return ret;
	}

}
/**
 * time: O(E + V)
 * v is the number of courses
 * e is the number of dependencies
 * 
 *  - take E time to build graph
 *  - perform a postorder dfs, vist each vertex and each edge once in the worst case E + V
 * 
 * 
 * Space: O(E + V)
 *  - built a graph, which consume E + V
 *  - during the backtracking, we use two bitmap (path and visited) to keep track visited path and status of checj
 *    , which consumes 2 * V space
 *  - implement recursion, which would incur additional memory consumption on call stack.
 *    - In the worst case where all node chained up in a line,
 *      recursion would pile up V time
 *      
 *  - Hence the overall space would be
 *    O(E + 4 * V) = O(E + V)
 * 
 * 
 */




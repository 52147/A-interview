package vo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak139 {
	
	public boolean wordBreak(String s, List<String> wordDict) {
		Queue<Integer> q = new LinkedList<>();
		
		Set<String> set = new HashSet<>(wordDict);
		
		q.add(0);
		boolean[] visited = new boolean[s.length()];
		while(!q.isEmpty()) {
			int start = q.remove();
			
			if(visited[start]) {
				continue;
			}
			
			for(int end = start + 1; end <= s.length(); end ++) {
				
				if(set.contains(s.substring(start, end))) {
					q.add(end);
					if(end == s.length()) {
						return true;
					}
				}
			}
			
			visited[start] = true;
			
		}
		
		return false;
	}

}

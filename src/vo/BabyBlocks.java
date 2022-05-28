package vo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BabyBlocks {
	static class Pair{
		
		public char c1, c2;
		public boolean used = false;
		public Pair(char c1, char c2) {
			this.c1 = c1;
			this.c2 = c2;
		}
		
	}
	
	private static boolean bkt(String word, int i, Map<Character, Set<Pair>> map) {
		
		if(i == word.length()) {
			return true;
		}
		
		boolean valid = false;
		
		Set<Pair> pairs = map.get(word.charAt(i));
		
		if(pairs == null) {
			return false;
		}
		
		for(Pair p : pairs) {
			
			if(p.used == false) {
				p.used = true;
				valid = valid || bkt(word, i + 1, map);
				p.used = false;
			}
		}
		
		return valid;
	}
	
	public static boolean valid(String word, List<Pair> pairs) {
		
		Map<Character, Set<Pair>> map = new HashMap<>();
		
		for(Pair p : pairs) {
			
			map.computeIfAbsent(p.c1, k -> new HashSet<>()).add(p);
			map.computeIfAbsent(p.c2, k -> new HashSet<>()).add(p);
			
		}
		
		return bkt(word, 0, map);
	}

}

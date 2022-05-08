package fall;

import java.util.HashMap;
import java.util.Map;

public class ST {
	
	public int Count(String a, String b) {
		
		char[] a1 = a.toCharArray();
		
		char[] b1 = b.toCharArray();
		
		Map<Character, Integer> map1 = new HashMap<>();
		
		Map<Character, Integer> map2 = new HashMap<>();
		
		for(char c: a1) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		
		System.out.println(map1);
		
		
		for(char c: b1) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}
		
		System.out.println(map2);
		
		int count = Integer.MAX_VALUE;
		
		for(char c: b1) {
			count = Math.min(count, map1.getOrDefault(c, 0));
		}
		
		return count;
		
	}
	
	
	public static void main(String[] args) {
		
		String a = "mononom";
		
		String b = "mon";
		
		ST s = new ST();
		
		int min = s.Count(a, b);
		
		System.out.println(min);
		// output:
		// {m=2, n=2, o=3}
		//	2

	}

}

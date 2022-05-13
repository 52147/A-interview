package fall;

import java.util.PriorityQueue;
import java.util.Queue;

public class Keypad {

	
		public int minimumClick(String str) {
			int[] frequency = new int[26];
			int res = 0;
			for (char s : str.toCharArray()) {
				frequency[s - 'a']++;
			}
			Queue<int[]> fre = new PriorityQueue<>((a, b) -> b[1] - a[1]);
			for (int i = 0; i < 26; i++) {
				if (frequency[i] != 0) {
					fre.add(new int[] { i, frequency[i] });
				}
			}
			int size = fre.size();
			for (int j = 0; j < size && j < 9; j++) {
				res += fre.poll()[1];
			}
			size = size - 9;
			for (int j = 0; j < size && j < 9; j++) {
				res += fre.poll()[1] * 2;
			}
			size = size - 9;
			for (int j = 0; j < size && j < 9; j++) {
				res += fre.poll()[1] * 3;
			}
			return res;

		}
	

}

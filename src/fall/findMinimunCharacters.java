package fall;
/**
 * 
 * search word = armaze
 * append o => armazeo
 * append n => armazeon
 * 
 * output = 2 (append two character o & n)
 * 
 * result word = amazon 
 * 
 * return the minimum number of characters to be appended to search word,
 * to make resultword transformable to search word
 *
 */
public class findMinimunCharacters {
	
	public int findMinimumCharacters(int searchWord[], int resultWord[]) {
		int p1 = 0;
		int p2 = 0;
		
		int n1 = searchWord.length;
		int n2 = resultWord.length;
		
		while(p1 < n1 && p2 < n2) {
			if(searchWord[p1] == resultWord[p2]) {
				p2 += 1;
			}
			p1 += 1;
		}
		
		return n2 - p2;
	}

}

package vo;
/**
 * 
 * 125. Valid Palindrome
 * 
 * - A phrase is palindrome if, after converting all uppercase letters into lowercase letters 
 *   and removing all non-alphanumeric characters, 
 *   it reads the same forward and backward.
 * - Alphanumeric characters include letters and numbers.
 * 
 * - Given a string s, return true if it is a palindrome, 
 *   or false otherwise.
 *   
 *   Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Approach : Two pointers
 * 
 * Intuition:
 * 
 * - If you take any ordinary string, 
 *   and concatenate its reverse to it,
 *   you'll get a palindrome.
 * - This leads to an interesting insight about the converse:
 *   every palindrome half is reverse of the other half.
 * 
 * - If one were to start in the middle of a palindrome,
 *   and traverse outwards,
 *   they'd encounter the same characters,
 *   in the exact same order, in both halves.
 *   
 * Algorithm:
 * - Since the input string contains characters that we need to ignore in our palindromic check,
 *   it becomes tedious to figure out the real middlle point of our palindromic input.
 *   
 * - Instead of going outwards from the middle,
 *   we could go inwards towards the middle.
 * - So, if we start traversing inwards, from both ends of the input string,
 *   we can expect to see the same characters, in the same order.
 * - The resulting algorithm is simple:
 *   - 1. set two pointers, one at each end of the input string.
 *   - 2. If the input is palindromic, both the pointers should point to equivalent characters,
 *        at all times.
 *        - If this condition is not met at any point of time,
 *          we break and return early.
 *   - 3. We can simply ignore non-alphanumeric characters by continuing to traverse further.
 *   - 4. Continue traversing inwards until the pointers meet in the middle.
 *   
 *   
 *
 */
public class ValidPalindrome125 {
	
	public boolean isPalindrome(String s) {
		for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			
			if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			
		}
		
		return true;
	}

}
/**
 * time : O(n), in length n of the string.
 * - We traverse over each character at most once, 
 *   until the two pointers meet in the middle,
 *   or when we break and return early.
 * space: O(1).
 * - No extra space required, at all.
 * 
 */





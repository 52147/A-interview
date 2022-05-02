package binarysearch;
/**
 * 
 * 278. First Bad Version 
 * 
 * boolean isBadVersion(version) returns whether version is bad
 * return the first bad version
 * 
 * 
 * you will need to implement a method can find the first bad version
 * 
 * - the first bad one will causes all the following ones to be bad.
 * 
 * suppose you have n versions [1, 2, ..., n]
 * 
 * input: n = 5
 * bad = 4
 * 
 * output : 4
 * 
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true // bad version
 * call isBadVersion(4) -> true // bad version
 * 
 * Approach: binary search
 * 
 *
 *
 */

// the isBadVersion API is defined in the parent class VersionControl.
// boolean isBadVersion(int version)
public class FirstBadVersion278 extends VersionControl{
	
	public int firstBadVersion(int n) { // n : number of version
		
		// use the left and right to decrease the range
		int left = 1;
		int right = n;
		
		while(left < right) {  // if the left is equal to right mean find the first bad version in left
			
			int mid  = left + (right - left)/2; // find the middle of the right and left
			
			if(isBadVersion(mid)) { // if mid is bad version(true) => move the right pointer to mid, which means after the right pointer are all bad version
				right  = mid;
			}else {
				left = mid + 1; // if mid is good version(false) => move forward the left pointer to check the new mid whether is the good or bad version
				             
			}
		}
		return left;
		
	}

}

/**
 * time: O(log n). the search is halved each time.
 * 
 * 
 * space: O(1)
 *  
 */



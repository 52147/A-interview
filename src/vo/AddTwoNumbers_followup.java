package vo;
/**
 * Follow up: no reverse order list
 *
 * What if the the digits in the linked list are stored in non-reversed order? For example:
 *
 * (3→4→2)+(4→6→5)=8→0→7
 * 
 * 3 -> 4 -> 2
 * 4 -> 6 -> 5
 * 
 * 8 -> 0 -> 7
 * 
 * Approach:
 * we can reverse l1 and l2 then use the same method to add it together
 * , then reverse the result list 
 * 
 * reverse method (iteration): time O(n) n:  list length / space O(1)
 *  1. set the prev pointer and cur.next pointer
 *  2. while loop(if curr is not null)
 *  3. change the cur.next pointer to prev
 *  4. move forward: find the next prev and next cur.next
 * 
 *
 */
public class AddTwoNumbers_followup {
	
	public ListNode add(ListNode l1, ListNode l2) {
		
		if(l1 == null) {
			return l2;
		}else if(l2 == null) {
			return l1;
		}
		
		l1 = reverse(l1);
		l2 = reverse(l2);
		
		ListNode dummy = new ListNode(0);
		
		ListNode p = l1;
		ListNode q = l2;
		ListNode curr = dummy;
		
		int carry = 0;
		
		while(p != null || q != null) {
			
			
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			
			int sum = x + y + carry;
			carry = sum / 10;
			
			curr.next = new ListNode(sum % 10);
			
			curr = curr.next;
			
			if(p != null) {p = p.next;}
			if(q != null) {q = q.next;}
			
		}
		
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		
		return reverse(dummy.next);
		
		
	}
	
	private ListNode reverse(ListNode node) {
		
		if(node == null || node.next == null) {
			return node;
		}
		// space: O(1)
		ListNode prev = null;
		ListNode curr = node;
		
		// time: O(n)
		while(curr != null) {
			
			ListNode nexttemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nexttemp;
		}
		
		return prev;
	}

}

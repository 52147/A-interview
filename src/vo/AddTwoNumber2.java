package vo;
/**
 * 2. add two number
 * 
 *  2 linked list 
 *  - each node has number value
 *  - sum it up 
 *  - and reverse add it in the linked list
 *  
 *  reverse order :
 *  - dummy node:  is important because without this node, we can use the pointer to point next, and aware the return value must be dummy.next
 *  - carry : if have a carry -> need to new a node at the next
 *  - aware pointer null exception: 
 *    - if we want to move pointer(l1 and l2 pointer) to next, 
 *    - we first need to check this pointer is not null(in this iteration) and check next pointer is not null(in next iteration)
 * 
 * 
 *  approach: linkedlist math
 *    
 *   1. set 3 pointer
 *      - one to the l1, another one to the l2
 *      - the other current pointer to the result linked list
 *        - the first node is the dummy and we set it 0 and the return node is dummy.next
 *          - because we need to add first node, we can use .next to add the next node of dummy
 *   2. use a while loop (keep iterating until l1 or l2 is not null)
 *   3. get the l1 and l2 node value(because we need to sum them up)
 *   4. set the carry: if have a carry (carry / 10) -> new a node at the next
 *   5. add a new node with the sum % 10 value
 *   6. move the current to the next      
 *      move the l1 to the next (if next not null)
 *      move the l2 to the next (if next not null)
 *      
 *   7. if the while loop stop and we still have the value in the carry(carry > 0)
 *      we need to new a node with carry value to the next node
 *   
 *   8. return dummy.next
 *      
 */
class ListNode{
	ListNode next;
	int val;
	
	ListNode(){}
	
	ListNode(int val){
		this.val = val;
	}
	
	ListNode(ListNode next, int val){
		this.next = next;
		this.val = val;
	}
}
public class AddTwoNumber2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// new the dummy node
		ListNode dummy = new ListNode(0); // space: max(m, n) + 1 because we add 1 dummy
		
		ListNode p = l1;
		ListNode q = l2;
		ListNode curr = dummy;
		
		int carry = 0;
		
		// time O(max(m, n)) m and n represent the length of l1 and l2, because we iterate max(m, n) times
		while(p != null || q != null) { // check the next p or next q is not null
			
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			
			int sum = x + y + carry;
			carry = sum / 10;
			
			curr.next = new ListNode(sum % 10);
			
			curr = curr.next;
			
			if(p != null) p = p.next; // if this iteration p is already null, no need to go next
			if(q != null) q = q.next; // (because next is null, so we need to first check this iteration p is null, otherwise we get null pointer exception)
			
			
		}
		
		
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		
		return dummy.next;
		
	}
	
	

}

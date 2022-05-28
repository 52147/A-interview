package vo;
/**
 * 
 * 86. Partition List
 * 
 * - Given a linked list and a value x,
 *   partition it such that all nodes less than x come before nodes greater than or equal to x.
 *   
 * - preserve the original relative order of the nodes in two partitions
 * 
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * 
 * Approach : two pointer 
 * 
 * Intuition:
 * - we can take two pointers before and after to keep track of two linked list.
 * - These two pointers could be used two create two separate lists and then these lists could be combined to form the desired reformed list.
 * 
 * Algorithm:
 * 
 * 1. 
 * - Initialize two pointers before and after.
 * - In the implementation we have initialized these two with a dummy listnode.
 * - This helps to reduce the number of conditional checks we would need otherwise.
 * 
 * 2. Iterate the original linked list, using the head pointer.
 * 3. if the node's value pointed by head is lesser than x,
 *    the node should be part of the before list.
 *    So we move it to before list.
 * 4. Else, the node should be part of after list.
 *    So we move it to after list.
 * 5. Once we are done with all the nodes in the original linked list,
 *    we would have two list before and after.
 *    The original list nodes are either part of before list or after list,
 *    depending on it value.
 *    
 *    - in the implementation, we remove the nodes from the original linked list 
 *      and attach then in the before and after list.
 *    - we don't utilize ant additional space.
 * 6. Now, these two lists before and after can be combined to form the reformed list.
 * 
 * 
 * - We did a dummy node initialization at the start to make implementation easier,
 *   you don't want that to be part of the returned list,
 *   hence just move ahead one node in both the lists while combining the two list.
 * - Since both before and after have an extra node at the front.
 *    
 *
 */
public class PartitionList86 {
	
	public ListNode partition(ListNode head, int x) {
		// before and after are the two pointers used to create the two list.
		// before_head and after_head are used to save the heads of the two lists.
		// All of these are initialized with the dummy nodes created.
		ListNode before_head = new ListNode(0);
		ListNode before = before_head;
		
		ListNode after_head = new ListNode(0);
		ListNode after = after_head;
		
		while(head != null) {
			
			// if the original list node is lesser than the given x,
			// assign it to the before list.
			if(head.val < x) {
				before.next = head;
				before = before.next;
			}else {
				// if the original list node is greater or equal to the given x,
				// assign it to the after list.
				after.next = head;
				after = after.next;
			}
			
			// move ahead in the original list
			head = head.next;
			
		}
		
		// last node of "after" list would alsot be ending node of the reformed list
		after.next = null;
		
		// once all the nodes are correctly assigned to the two lists,
		// combine them to form a single list which would be returned.
		before.next = after_head.next;
		
		return before_head.next;
	}

}
/**
 * time: O(N), where N is the number of nodes in the original linked list and we iterate the original list.
 * space: O(1), we have not utilized any extra space, the point to note is that we are reforming the original list,
 *        by moving the original node, we have not used any extra space as such.
 * 
 */



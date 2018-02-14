/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class SwapNodesInPairs {
	public static void main(String[] args) {
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(swapPairs(node1));
	}
	public static LinkedListNode swapPairs(LinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = head;
		head = dummy;
		while (head.next != null && head.next.next != null) {
			LinkedListNode n1 = head.next, n2 = head.next.next;
			head.next = n2;
			n1.next = n2.next;
			n2.next = n1;
			
			head = n1;
		}
		return dummy.next;
	}
}
//time: O(n), space: O(1)

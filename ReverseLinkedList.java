/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */

public class ReverseLinkedList {
	public static void main(String[] args) {
		System.out.println();
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		LinkedListNode res = reverseLinkedlist(node1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	public static LinkedListNode reverseLinkedlist(LinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		LinkedListNode pre = null;
		while (head != null) {
			LinkedListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	}
}

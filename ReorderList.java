/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given 1->2->3->4, return 1->4->2->3
 */
public class ReorderList {
	public static void main(String[] args) {
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		reorderList(node1);
		while (node1 != null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}
	
	public static void reorderList(LinkedListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		LinkedListNode mid = getMid(head);
		LinkedListNode rev = getReverse(mid.next);
		mid.next = null;
		merge(head, rev);
	}
	
	private static LinkedListNode getMid(LinkedListNode head) {
		LinkedListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private static LinkedListNode getReverse(LinkedListNode head) {
		LinkedListNode pre = null;
		while (head != null) {
			LinkedListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	}
	private static void merge(LinkedListNode head1, LinkedListNode head2) {
		LinkedListNode dummy = new LinkedListNode(0);
		int index = 0;
		while (head1 != null && head2 != null) {
			if (index % 2 == 0) {
				dummy.next = head1;
				head1 = head1.next;
			} else {
				dummy.next = head2;
				head2 = head2.next;
			}
			dummy = dummy.next;
			index++;
		}
		if (head1 != null) {
			dummy.next = head1;
		}
		if (head2 != null) {
			dummy.next = head2;
		}
	}
}
//time: O(n), space: O(n)
//思路是找中点，然后reverse后一边，然后merge 这2个linked list

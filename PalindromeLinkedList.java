/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class PalindromeLinkedList {
	public static void main(String[] args) {
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(2);
		LinkedListNode node5 = new LinkedListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		System.out.println(isPalindrome(node1));
	}
	public static boolean isPalindrome(LinkedListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		LinkedListNode mid = getMid(head);
		LinkedListNode next = mid.next;
		LinkedListNode reverseNode = reverse(next);
		return compare(head, reverseNode);	
	}
	
	private static LinkedListNode getMid(LinkedListNode head) {
		LinkedListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	private static LinkedListNode reverse(LinkedListNode head) {
		LinkedListNode pre = null;
		while (head != null) {
			LinkedListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	}
	private static boolean compare(LinkedListNode head1, LinkedListNode head2) {
		if (head1 == null && head2 == null) {
			return true;
		}
		while (head1 != null && head2 != null) {
			if (head1.val != head2.val) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return true;
	}
}	
//time: O(n), space: O(1)

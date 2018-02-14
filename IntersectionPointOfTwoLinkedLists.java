/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class IntersectionPointOfTwoLinkedLists {
	public static void main (String[] args) {
		LinkedListNode node0 = new LinkedListNode(2);
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(2);
		LinkedListNode node6 = new LinkedListNode(2);
		LinkedListNode node7 = new LinkedListNode(3);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;

		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		LinkedListNode res = IntersectionPointOfTwoLinkedLists(node0, node4);
		System.out.println(res.val);
	}
	public static LinkedListNode IntersectionPointOfTwoLinkedLists (LinkedListNode head1, LinkedListNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		
		int len1 = getLength(head1);
		int len2 = getLength(head2);
		
		if (len1 > len2) {
			while (len1 != len2) {
				head1 = head1.next;
				len1--;
			}
		} else {
			while (len1 != len2) {
				head2 = head2.next;
				len2--;
			}
		}
		//
//		while (head1.val != head2.val) {
//			head1 = head1.next;
//			head2 = head2.next;
//		}
		while (head1 != null) {
			if (head1.val == head2.val) {
				return head1;
			}
			head1 = head1.next;
			head2 = head2.next;
		}
		return null;
	}
	
	private static int getLength (LinkedListNode head) {
		if (head == null) {
			return 0;
		}
		int len = 0;
		while(head != null) {
			head = head.next;
			len++;
		}
		return len;
	}
}

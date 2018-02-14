/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class DeleteNodeWithAGivenKey {
	public static void main(String[] args) {
		System.out.println();
		LinkedListNode node0 = new LinkedListNode(2);
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node6 = new LinkedListNode(2);
		LinkedListNode node7 = new LinkedListNode(2);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(2);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
//		while (node1 != null) {
//			System.out.print(node1.val + "-");
//			node1 = node1.next;
//		}
//		System.out.println("-------");
		deleteNodeWithAGivenKey(node1, 3);
		while (node1 != null) {
			System.out.print(node1.val + "-");
			node1 = node1.next;
		}
	}
	
	public static LinkedListNode deleteNodeWithAGivenKey(LinkedListNode head, int key) {
		if (head == null) {
			return head;
		}
		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = head;
		head = dummy;
		
		while (head.next != null) {
			if (head.next.val == key) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}
}

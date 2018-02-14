/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class OddEvenLinkedList {
	public static void main(String[] args) {
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		LinkedListNode res = oddEvenList(node1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
	public static LinkedListNode oddEvenList(LinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkedListNode odd = head;
		LinkedListNode even = head.next;
		LinkedListNode evenHead = even; //连接odd 的末尾和even 的头
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
//time: O(n), space; O(1)

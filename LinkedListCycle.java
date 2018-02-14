/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * boolean if has cycle or not
 */
public class LinkedListCycle {
	public static void main(String[] args) {
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		//node4.next = node2;
		System.out.println(hasCycle(node1));
	}
	public static boolean hasCycle(LinkedListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		LinkedListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}
}
//time: O(n), space: O(1) just a few pointers
//bug: while 用的是fast 判断而不是head, head.next 判断
//bug2, while 用的是fast and fast.next 而不是fast.next, fast.next.next 判断，其实不用
//因为只要fast, fast.next 不为null, 就不会出现null pointer exception, 至于fast.next.next 
//是否是null, 不影响， 是null, return false.

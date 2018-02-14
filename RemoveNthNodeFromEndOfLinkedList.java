/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class RemoveNthNodeFromEndOfLinkedList {
	public static void main(String[] args) {
		System.out.println();
		LinkedListNode node0 = new LinkedListNode(2);
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		LinkedListNode node5 = new LinkedListNode(2);
		LinkedListNode node6 = new LinkedListNode(2);
		LinkedListNode node7 = new LinkedListNode(2);
	
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		removeNthFromEnd(node0, 3);
		while (node0 != null) {
			System.out.print(node0.val + "-");
			node0 = node0.next;
		}
	}
	
	public static LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
		if (head == null) {
			return head;
		}
		LinkedListNode dummy = new LinkedListNode(0);
		LinkedListNode fast = dummy, slow = dummy;
		slow.next = head;
		
		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}
		
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
//time: O(n), space: O(1)

//time: O(n), space; O(1)
//思路是2个指针都从dummy 开始，fast 先走n+1步，等着slow 从dummy 开始一起走，当fast 走到null的时候，slow 距离它是n+1步，意思是从slow 走到null 需要走n+1步，也就是说slow 走到tail 是n步，也就是是slow 是倒数第n+1个节点，slow.next 就是倒数的第n个节点，（可以画图看这个关系）。
//这个题的关键是要找到倒数第n+1个节点，因为要删去的是倒数第n个节点，所以需要它前一个的节点。
//用2个指针保持他们之间的距离是n+1，这个距离指的是一个指针走n+1步到达第二个指针。所以这里保持快慢指针之间的距离是n+1， 快慢指针都是从dummy 开始走，快的走n+1步，当走到n+1这个节点的时候，慢的在dummy, 这个时候2个指针之间的距离是n+1,然后2个指针同步走，当快的走到null 的时候，慢的走到了倒数的第n+1个节点，也即是要删去节点的前一个节点。

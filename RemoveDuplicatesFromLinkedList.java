/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuemaomao
 * remove the dupilicates, only keep the first occurance of duplicates
 * 1->2->3->2->1->4 
 * return 1->2->3->4
 */
public class RemoveDuplicatesFromLinkedList {
	public static void main(String[] args) {
		System.out.println();
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(2);
		LinkedListNode node3 = new LinkedListNode(3);
		LinkedListNode node4 = new LinkedListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		removeDuplicatesFromLinkedList(node1);
		while (node1 != null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}
	
	public static LinkedListNode removeDuplicatesFromLinkedList(LinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		Set<Integer> set = new HashSet<>();
		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = head;
		head = dummy;
		
		while (head.next != null) {
			if (set.contains(head.next.val)) {
				head.next = head.next.next;
			} else {
				set.add(head.next.val);
				head = head.next;
			}
		}
		return dummy.next;
	}
}
//time: O(n) space: O(n) hashSet
//因为删去的时候需要前置节点，所以判断的时候用head.next， 判断的总是下一个节点，这样就可以记下Pre的位置

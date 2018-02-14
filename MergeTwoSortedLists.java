/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuemaomao
 *
 */
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(4);
		node4.next = node5;
		ListNode head = mergeTwoLists(node1, node4);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println();
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null) {
			cur.next = l1;
		}
		if (l2 != null) {
			cur.next = l2;
		}
		return dummy.next;
	}
}

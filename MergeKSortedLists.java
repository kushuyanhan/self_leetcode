/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author xuemaomao
 * 1->2->5->null
 * 3->4->null
 * 2->7->null
 * method1, heap
 * method2, divide and conquer
 */
public class MergeKSortedLists {
	public static void main(String[] args) {
		System.out.println();
		List<ListNode> lists = new ArrayList<>();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		lists.add(node1);
		
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(4);
		node4.next = node5;
		lists.add(node4);
		
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node6.next = node7;
		lists.add(node6);
		
		//ListNode res = mergeKLists(lists);
		ListNode res = mergeKLists2(lists);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}	
	}
	//method1: priority queue
	//time: O(nlogk), k is the number of linked list, n is the total number of nodes in k lists
	//space: O(n) create n nodes linked list, O(k) priority queue created, but k is much less than n, so space is O(n)
	public static ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});
		//here 把每个List的头加入queue, 而不是把每一个linkedlist 的整个都加进来!
		for (ListNode node : lists) {
			if (node != null) {
				queue.offer(node);
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while (!queue.isEmpty()) {
			cur.next = queue.poll();
			cur = cur.next;
			if (cur.next != null) {
				queue.add(cur.next);
			}
		}
		return dummy.next;
	}
	
	//method2: divide and conque, 是把lists 里面的List不断的divide,分到最后就是单独的一个个list, 然后再两两合并，就是merge 2 sorted list
	//time: O(nlogk), space: O(1), 
	//k is the number of linked list in lists, n is the total number of nodes.
	//merge 2 sorted list space: O(m+n), 
	//traverse almost n nodes per pairing and merging, and repeat this procedure about logk times
	public static ListNode mergeKLists2(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		return mergeHelper(lists, 0, lists.size() - 1);
	}
	
	public static ListNode mergeHelper(List<ListNode> lists, int start, int end) {
		if (start == end) {
			return lists.get(start);
		}
		int mid = start + (end - start) / 2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid + 1, end);
		
		return mergeTwoLists2(left, right);
	}
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
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
//merge sort 用于外排序，最大缺点是需要额外的空间存

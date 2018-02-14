/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuemaomao
 *
 */

class RandomListNode {
	 int label;
	 RandomListNode next, random;
	 RandomListNode(int x) { this.label = x; }
}

public class CopyListWithRandomPointer {
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		node3.next = node1;
		System.out.println();
		while (node1 != null) {
			System.out.println(node1.label + "random");
			node1 = node1.next;
		}
	}
	
	private RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		//copy nodes
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode node = head;
		while (node != null) {
			if (!map.containsKey(node)) {
				map.put(node, new RandomListNode(node.label));
			}
			node = node.next;
		}
		//copy pointers
		node = head;
		while (node != null) {
			if (node.next != null) {
				map.get(node).next = map.get(node.next);
			}
			if (node.random != null) {
				map.get(node).random = map.get(node.random);
			}
			node = node.next;
		}
		return map.get(head);
	}
}
//time: O(n), space: O(n) hashmap

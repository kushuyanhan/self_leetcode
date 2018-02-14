package leetcode;
class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
//(2 -> 4 -> 3) + (5 -> 6 -> 4)
//return 7->0->8
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(8);
		ListNode node6 = new ListNode(9);
		
		node1.next = node2;
		node2.next = node3;
		node4.next = node5;
		node5.next = node6;
		
		System.out.println(addTwoNumbers(node1, node4));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0;
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (l1 == null || l2 == null) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			cur.next = new ListNode(sum % 10); //本位
			sum /= 10; //carry
			cur = cur.next;
		}
        if (sum == 1) {
        	cur.next = new ListNode(1);
        }
		return dummy.next;
	}
}

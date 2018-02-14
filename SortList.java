/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given 3->1->4->9->2 , sort it and return 
 */
public class SortList {
	public static void main(String[] args) {
		LinkedListNode node1 = new LinkedListNode(1);
		LinkedListNode node2 = new LinkedListNode(3);
		LinkedListNode node3 = new LinkedListNode(2);
		LinkedListNode node4 = new LinkedListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		
		LinkedListNode res = sortList(node1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	  public static LinkedListNode sortList(LinkedListNode head) {
	    if (head == null || head.next == null) {
	        return head;
	    }	    
	   //1) divide into halfs recursively
	    LinkedListNode mid = findMid(head);
	    LinkedListNode nextOfMid = mid.next;
	    mid.next = null;
	   
	   LinkedListNode left = sortList(head);
	   LinkedListNode right = sortList(nextOfMid);
	   return merge(left, right);
	}
    private static LinkedListNode findMid(LinkedListNode head) {
    	LinkedListNode fast = head.next;
    	LinkedListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
	    
    private static LinkedListNode merge(LinkedListNode head1, LinkedListNode head2) {
    	LinkedListNode dummy = new LinkedListNode(0);
    	LinkedListNode head = dummy;
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        
        if (head1 != null) {
            head.next = head1;
        }
        if (head2 != null) {
            head.next = head2;
        }
        return dummy.next;
    }
}
//time: O(nlogn), space: O(logn)
//for linked list, merge sort is better than quick sort, 
//因为quick sort 要swap, Linked list 的swap 不方便， 需要指针衔接，所以选择merge sort

//bug1, findMid 的时候fast 要先走一步, 因为fast 如果从head 开始走，假设linked list 有偶数个，
//mid 返回的是中间2个节点的后一个，所以fast 提前一步走，可以保证返回的是中间2个节点的前一个， 
//bug2. mid.next = null， 否则会stack over flow


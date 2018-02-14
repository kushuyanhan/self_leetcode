/**
 * 
 */
package leetcode;

import java.util.PriorityQueue;

/**
 * @author xuemaomao
 * find kth largest number in an unsorted array, using minheap
 */
public class KthLargestNumberHeap {
	public static void main(String[] args) {
		int[] nums = {3,5,1,7,6,9, 7};
		int k = 3;
		int res = kthLargestElement(3, nums);
		System.out.println(res);
	}
	public static int kthLargestElement(int k, int[] nums) {
		//using min heap
        if (nums == null) {
        	return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
        	pq.add(num);
        	if (pq.size() > k) {
        		pq.poll();
        	}
        }
		return pq.peek();  
	}     
}
//time: O(nlgk), space: O(k) due to heap

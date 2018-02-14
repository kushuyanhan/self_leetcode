package leetcode;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = {4, 3, 8, 2};
		quickSort(nums);	
		System.out.println(Arrays.toString(nums));
	}
	private static void quickSort(int[] A) {
		if (A == null || A.length == 0) {
	        return;
	    }
	    helper(A, 0, A.length - 1);
	}

	private static void helper(int[] A, int start, int end) {
	    if (start >= end) { //表示只剩一个数不能再走了
	       return;
	    }
	    int left = start, right = end;
	    int pivot = A[(start + end) / 2]; //pivot 是value, 不是index
	    
	    while (left <= right) { //启发中有总结
	        while (left <= right && A[left] < pivot) {
	            left++;
	        }
	        while (left <= right && A[right] > pivot) {
	            right--;
	        }
	        
	        if (left <= right) {  
	            int temp = A[left];
	            A[left] = A[right];
	            A[right] = temp;
	            left++;
	            right--;
	        }
	    }
	    helper(A, start, right);
	    helper(A, left, end);
	}
}
//time: O(nlogn), space: O(logn) recursive on stack
// // key point 1: pivot is the value, not the index
//  //key point 2: left<= right not left < right， 因为这样就是保证最后是[start,right],[left, end] 中间没有交集
//  // key point 3: A[left] < pivot not A[left] <= pivot

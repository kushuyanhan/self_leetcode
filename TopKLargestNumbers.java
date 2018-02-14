package leetcode;

import java.util.Random;

public class TopKLargestNumbers {
	public static void main(String[] args) {
		int[] nums = {3,5,1,7,6,9};
		int k = 3;
		int[] res = topk(nums, 3);
		for (int i : res) {
			System.out.println(i);
		}
	}
	public static int[] topk(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k);
        int[] topk = new int[k];
        for (int i = 0; i < k; ++i)
            topk[i] = nums[i];
        return topk;     
    }       
    //method2 based on quick sort
    private static void quickSort(int[] A, int start, int end, int k) {
        if (start >= k)
            return;

        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        //Random rand = new Random(end - start + 1);
        //int index = rand.nextInt(end - start + 1) + start;
        //int pivot = A[index];
        int pivot = A[start + (end - start) / 2];

        // key point 2: every time you compare left & right, it should be 
        // left <= right not left < right
        while (left <= right) {
            // key point 3: A[left] < pivot not A[left] <= pivot
            while (left <= right && A[left] > pivot) {
                left++;
            }
            // key point 3: A[right] > pivot not A[right] >= pivot
            while (left <= right && A[right] < pivot) {
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
        
        quickSort(A, start, right, k);
        quickSort(A, left, end, k);
    }
}

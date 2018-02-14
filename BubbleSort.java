package leetcode;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {6,4,3,1,8};
		bubbleSort(arr);
		System.out.println();
	}
	
	public static void bubbleSort(int[] arr) {
	    int length = arr.length;
	    for (int i = length - 1; i >= 0; i--) {
	        int flag = 0;
	        for (int j = 0; j < i; j++) {
	            if (arr[j] > arr[j + 1]) {
	                //swap(arr, i, j);
	                flag = 1;
	            }
	        }
	        if (flag == 0) break;
	    }
	}
	private void swap(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}

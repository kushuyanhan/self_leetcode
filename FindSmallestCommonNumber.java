package leetcode;
/*
 * find the smallest common number of several sorted arrays*/
public class FindSmallestCommonNumber {
	public static void main(String[] args) {
		//System.out.println();
		int[] a = {1, 2, 3};
		int[] b = {0, 1, 2, 3};
		int[] c = {-1, 1, 2, 3};
		System.out.println(findSmallestCommonNumber(a, b, c));
	}
	
	public static int findSmallestCommonNumber(int[] a, int[] b, int[] c) {
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length && k < c.length) {
			if (a[i] == b[j] && b[j] == c[k]) {
				return a[i];
			} else if (a[i] < b[j] && a[i] < c[k]){
				i++;
			} else if (b[j] < a[i] && b[j] < c[k]) {
				j++;
			} else if (c[k] < a[i] && c[k] < b[j]) {
				k++;
			}
		}
		return -1;
	}
}
//time: O(n), space: O(1)

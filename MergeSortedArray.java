/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given 2 sorted arrays, merge nums2 into nums1 as sorted array
 */
public class MergeSortedArray {
	public static void main(String[] args) {
		System.out.println();
	}
	
	public void merge(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
			return;
		}
		int m = nums1.length, n = nums2.length;
		int i = m - 1, j = n - 1, index = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i--];
			} else {
				nums1[index--] = nums2[j--];
			}
		}
		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}
	}
}
//time: O(m + n), space: O(1)
//bug1: 不用考虑nums1 多余的, 这个时候nums2 已经走完了，nums2 的元素全部已经弄到nums1 了，剩下的nums1 
//如果没有走完，就不用再一个一个过了，因为就是要全部弄到nums1, 而且num1 is already sorted.

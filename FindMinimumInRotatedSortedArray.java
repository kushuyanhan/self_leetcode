/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * [4,5,1,2,3] find minimum
 */
public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums= {4,5,1,2,3};
		System.out.println(findMin(nums));
	}
	
	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] < nums[end]) {
			return nums[start];
		}
		return nums[end];
	}
}

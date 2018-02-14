/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 *
 */
public class WiggleSort {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void wiggleSort(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		for (int i = 1; i < nums.length; i++) {
			if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1])) {
				int temp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = temp;
			}
		}
	}
}

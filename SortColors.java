/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 * Given [1,1,0,2,1,2,2,0], reresents 3 colors, group them as all 0s together, 1s together, 2s together
 * return [0,0,1,1,1,2,2,2]
 */
public class SortColors {
	public static void main(String[] args) {
		int[] nums = {1,1,0,2,1,2,2,0};
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void sortColors(int[] nums) {
		int left = 0, right = nums.length - 1;
		int i = 0;
		while (i <= right) {
			if (nums[i] < 1) {
				swap(nums, left++, i++);
			} else if (nums[i] > 1) {
				swap(nums, i, right--);
			} else {
				i++;
			}
		}
	}
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}

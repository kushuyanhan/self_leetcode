/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 *	sort color by k colors, from 1 to k
 *k partition
 */
public class SortColorsii {
	public static void main(String[] args) {
		int[] nums = {3,2,3,1,4,2,5,5,6,3,2,4,1,6};
		sortColorsii(nums, 6);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void sortColorsii(int[] nums, int k) {
		int left = 0, right = nums.length - 1;
		int lowColor = 1, highColor = k;
		int cur;
		while (lowColor < highColor) {
			cur = left;
			while (cur <= right) {
				if (nums[cur] == lowColor) {
					swap(nums, cur++, left++);
				} else if (nums[cur] == highColor) {
					swap(nums, cur, right--);
				} else {
					cur++;
				}
			}
			lowColor++;
			highColor--;
		}
	}
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}

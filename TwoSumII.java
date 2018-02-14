/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 * input array is sorted
 */
public class TwoSumII {
	public static void main(String[] args) {
		int[] nums = {2,4,6};
		int target = 7;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int sum = nums[i] + nums[j];
			if (sum < target) {
				i++;
			} else if (sum > target) {
				j--;
			} else {
				return new int[]{i + 1, j + 1};
			}
		}
		throw new IllegalArgumentException("no two sum solution");
	}
}
//time: O(n), space: O(1)

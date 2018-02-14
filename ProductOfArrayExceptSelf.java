package leetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] res = productExceptSelf(nums);
		for (int num : res) {
			System.out.print(num + " ");
		}
	}

	public static int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int[] res = new int[nums.length];
		res[0] = 1;
		//left numbers product
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		//right numbers product
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
}
//time: O(n) space: O(n) extra array

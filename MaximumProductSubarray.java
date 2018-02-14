package leetcode;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		int[] nums = {2, 3, -2, 4};
		System.out.println(maxProduct(nums));
	}
	
	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int min = nums[0];
		int rst = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				max = Math.max(nums[i], max * nums[i]);
				min = Math.min(nums[i], min * nums[i]);
			} else {
				int oldMax = max;
				max = Math.max(nums[i], min * nums[i]);
				min = Math.min(nums[i], oldMax * nums[i]);
			}
			rst = Math.max(rst, max);
		}
		return rst;
	}
}
//time: O(n), O(1)
//因为nums 里面有可能有负数，所以要记录下每一个循环的max, min, 在计算max, min 的时候要考虑当前的数
//nums, 也有可能是最值，
//计算min, 的时候，要用到上一轮的max, 所以要提前存好上一轮的max, 也就是temp = max.

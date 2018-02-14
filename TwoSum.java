package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {2, 7, 1, 8, 9};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[]{-1, -1};
		}
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]) + 1;
				res[1] = i + 1;
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}
}
//time: O(n), space: O(n)

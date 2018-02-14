package leetcode;

public class SingleElementInASortedArray {
	public static void main(String[] args) {
		int[] nums = {1,1,2,3,3};
		System.out.println(singleNonDuplicate(nums));
		
	}
	public static int singleNonDuplicate(int[] nums) {
		int low = 0, high = nums.length / 2;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[2 * mid] != nums[2 * mid + 1]) {
				System.out.println(nums[2 * mid]);
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		return nums[2 * low];
	}
}
//time: O(logn), space: O(1)

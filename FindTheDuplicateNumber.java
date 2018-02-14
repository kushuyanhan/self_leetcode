/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given an array, contain n+1 numbers, which are from 1 to n, find the duplicate number, 
 * Assume only 1 duplicate. space must O(1)
 */
//can't use hashMap, hashSet due to the space limit.
//method1 binary search by index
//method2 linked list cycleii, find the entrance of the cycle

public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		int[] nums = {1,2,3,2,4};
		System.out.println(findDuplicate(nums));
		System.out.println(findDuplicate2(nums));
	}
	
	public static int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 1, end = nums.length;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (countSmaller(nums, mid) <= mid) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (countSmaller(nums, start) <= start) {
			return end;
		}
		return start;
	}
	
	public static int countSmaller(int[] nums, int mid) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= mid) {
				count++;
			}
		}
		return count;
	}
	public static int findDuplicate2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int slow = nums[0];
		int fast = nums[nums[0]];
		
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast) {
				int slow2 = 0;
				while (slow2 != slow) {
					slow = nums[slow];
					slow2 = nums[slow2];
				}	
			}
		}
		return slow;
	}
}

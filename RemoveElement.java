/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given an array and a target, remove the target, all instances removed. No extra space, 
 * in place modify array. return new length of array
 */
public class RemoveElement {
	public static void main(String[] args) {
		int[] nums= {1, 2,2 , 1,3};
		System.out.println(removeElement(nums, 2));
	}
	public static int removeElement(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
}
//time: O(n), space: O(1)

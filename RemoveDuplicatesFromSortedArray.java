/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 * remove duplicates from sorted array, and return the new length of array
 */
public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = {3,5,1,7,6,9, 1,3,5,7};
		int res = remove(nums);
		System.out.println(res);
	}
	public static int remove(int[] nums) {
        if (nums == null) {
        	return -1;
        }
        Arrays.sort(nums);
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] != nums[i - 1]) {
        		nums[++index] = nums[i];
        	}
        }
		return index + 1;  
	}
}
//time: O(nlogn), space: O(1)

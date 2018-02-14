/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuemaomao
 *
 */
public class Subsets {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(subsets(nums));
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		helper(nums, 0, res, new ArrayList<Integer>());
		return res;
	}
	
	public static void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
		res.add(new ArrayList<Integer>(list));
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			helper(nums, i + 1, res, list);
			list.remove(list.size() - 1);
		}
	}
	
}

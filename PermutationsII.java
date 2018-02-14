package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		List<List<Integer>> res = permuteUnique(nums);
		System.out.println(res.toString());
	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums); //for skipping duplicates
        helper(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;    
    }
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            helper(nums, res, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

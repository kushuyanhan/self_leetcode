package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		int[] nums = {2,3,5};
		List<List<Integer>> res = combinationSum(nums, 5);
		System.out.println(res.toString());
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, new ArrayList<Integer>(), 0, res, target);
        return res;
    }
    private static void helper(int[] candidates, List<Integer> list, int startIndex, List<List<Integer>> res, int remainTarget) {
        if (remainTarget == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (remainTarget < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, list, i, res, remainTarget - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
//time: O(2^n), space: O(n)
//[2,3,5] target = 5,
//recursive 的过程如下，注意，这里当【2，2，2】，已经超过了5的时候，下一次依旧是【2，2，3】， 这样dfs, 并没有把完全不可能的提前剪职。
//[2,2,2],[2,2,3],[2,2,5],[2,3](yes),[2,5],[3,3],[3,5],[5](yes)

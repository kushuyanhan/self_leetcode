package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum3(3, 9);
		System.out.println(res.toString());
	}
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    private static void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (k < 0 || n < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, n - i, k - 1, i + 1); //k 每次减去1个数，n 每次减掉当前的nums[i]
            list.remove(list.size() - 1);
        }
    }
}

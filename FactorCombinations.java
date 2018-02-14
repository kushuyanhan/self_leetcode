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
public class FactorCombinations {
	public static void main(String[] args) {
		System.out.println(getFactors(12));
	}
	
	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), n, 2);
		return res;
	}
	private static void helper(List<List<Integer>> res, List<Integer> list, int n, int start) {
		if (n == 1) {
			if (list.size() > 1) {
				res.add(new ArrayList<Integer>(list));
			}
		}
		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				list.add(i);
				helper(res, list, n / i, i);
				list.remove(list.size() - 1);
			}
		}
	}
}
//12
//[2,2,3],[2,6],[3,4]

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
public class SummaryRanges {
	public static void main(String[] args) {
		System.out.println();
		int[] nums = {0,1,2,4,5,7};
		System.out.println(summaryRanges(nums));
	}
	
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];;
			while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) {
				i++;
			}
			if (a != nums[i]) {
				res.add(a + "->" + nums[i]);
			} else {
				res.add(nums[i] + "");
			}
		}
		return res;
	}
}
//time: O(n), space: O(n)


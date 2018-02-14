/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuemaomao
 * [3, 5, 12,13,16],0, 20
 * return [0->2,4,6->11,14->15,17->20]
 */
public class MissingRanges {
	public static void main(String[] args) {
		int[] nums = {-2147483648,0,2147483647};
		int lower = -2147483648, upper = 2147483647;
		int[] nums2 = {3,5,8,9};
		int alower2 = 1, ahigher2 = 10;
		System.out.println(findMissing2(nums2, alower2, ahigher2));
	}
	
	public static List<String> findMissing(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		for (int num : nums) {
			//越界
			if (num == Integer.MIN_VALUE) {
				lower = num + 1;
				continue;
			}
			if (lower == num - 1) {
				res.add("" + lower);
			} else if (lower < num - 1) {
				res.add(lower + "->" + (num - 1));
			}
			if (num == Integer.MAX_VALUE) {
				return res;
			}
			lower = num + 1;
		}
		if (lower == upper) {
			res.add("" + lower);
		} 
		if (lower < upper) {
			res.add(lower + "->" + upper);
		}
		return res;
	}
	//lower=1, higher=10, [3,5->7, 9] return [1->2,3,4,5->7, 8,9,10]
	public static List<String> findMissing2(int[] nums, int lower, int higher) {
		long alower = (long)lower, ahigher = (long)higher;
		List<String> res = new ArrayList<>();
		for (int num : nums) {
			if (alower == num) {
				alower = num + 1;
			} else if (alower == num - 1) {
				res.add(String.valueOf(alower));
				alower = num + 1;
			} else if (alower < num - 1){
				res.add(alower + "->" + (num - 1));
				alower = num + 1;
			}
		}
		if (alower == ahigher) {
			res.add(String.valueOf(alower));
		} else {
			res.add(alower + "->" + (ahigher - 1));
		}
		return res;
	}
}

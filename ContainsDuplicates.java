/**
 * 
 */
package leetcode;

import java.util.Set;
import java.util.HashSet;

/**
 * @author xuemaomao
 *
 */
public class ContainsDuplicates {
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(containsDuplicate(nums));
	}
	
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (set.contains(num)) {
				return true;
			} 
			set.add(num);
		}
		return false;
	}
}
//time;O(n), space: O(n)

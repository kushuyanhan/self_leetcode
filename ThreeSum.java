/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuemaomao
 * a+b+c=0, S = [-1,0,1,2,-1.-4];
 * return [[-1,0,1],[-1,-1,2]], 重复集合不算
 */
public class ThreeSum {
	public static void main(String[] args) {
		int[] nums= {-1,0,1,2,-1,-4};
		List<List<Integer>> res= threeSum(nums);
		for (List list : res) {
			System.out.println(Arrays.toString(list.toArray()));
		}
		//System.out.println(res);
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			
			int sum = 0 - nums[i];
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] == sum) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (nums[left] + nums[right] < sum) {
					left++;
				} else {
					right--;
				}
			}
			while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
				i++;//选择重复数字的第一次出现的数
			}
		}
		return res;
	}
}
//time: O(n^2), space: O(1)
//Arrays.asList(arr) or Arrays.asList(nums[i], nums[j]) 把数组转换成list.比较方便

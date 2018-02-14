package leetcode;

public class MajorityElement {
	public static void main(String[] args) {
		int[] nums = {1, 2,2,2, 1};
		System.out.println(findMajority(nums));
	}
	public static int findMajority(int[] nums) {
		int count = 0;
	    int res = nums[0];
	    for (int num : nums) {
	        if (count == 0) {
	            res = num;
	        }
	        if (num != res) {
	            count--;
	        } else {
	            count++;
	        }  
	    }
	    return res;
	}
}
//time: O(n), space: O(1)
//思路是配对，不相同的数组配一组，count--, 相同的,count++, 当count==0 说明目前为止的配对完成，每一对都是不相同的2个数字
//method2, hashmap 计算每个数出现的次数space:O(n)

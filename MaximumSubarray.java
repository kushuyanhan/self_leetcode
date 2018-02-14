/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * 找到连续的子串，使得sum 最大， 返回最大和
 * [-2, 1,-3,4,-1,2,1,-5,4] [4,-1,2,1] largetst sum is 6
 */
public class MaximumSubarray {	
	public static void main(String[] args) {
		int[] arr2 = new int[]{-3,-2,4,-1};
		System.out.println(maxSubArray2(arr2));
		System.out.println(minSubArray(arr2));
		//System.out.println(minSubArray2(arr2));
	}
	//method1
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}
	//method2
	//dp cur 记录的是当前的最大值，res 记录的global 最终的最大值，当前的最大值不一定是最终的最大值，所以需要一个globl res
	public static int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = nums[0];
		int cur = nums[0];
		for (int i = 1; i < nums.length; i++) {
			cur = Math.max(nums[i], cur + nums[i]);			
			res = Math.max(res, cur);
		}
		return res;
	}
	//{3,-2,4,-1}
	//res: 3, cur: 3
	//cur=1, res=3
	//cur=5, res=5
	//cur=4, res = 5
	//min sub array 通用的方法类似于max sub array
	public static int minSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = nums[0];
		int cur = nums[0];
		for (int i = 1; i < nums.length; i++) {
			cur = Math.min(nums[i], cur + nums[i]);
			res = Math.min(res, cur);
		
		}
		return res;
	}
}
//{-3,-2,4,-1}
//cur=-3, res=-3
//cur=-5, res =-5

//cur=-1, res=-5
//cur=-2, res =-5


//time: O(n), space: O(1)
//bug1, 2个if的顺序不能颠倒，否则wrong, [-1,-3] return 0 


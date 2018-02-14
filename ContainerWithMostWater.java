/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * given height[], means height, get max area that 2 heigths and x-axi surrounded
 */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] height = {1,5,3,2,6,4,8,3};
		System.out.println(maxArea(height));
	}
	
	public static int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int l = 0, r = height.length - 1;
		int res = 0;
		while (l < r) {
			res = Math.max(res, (r - l) * (Math.min(height[l], height[r])));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}
}
//time: O(n), space: O(1)
//往最有希望的方向移动l, r, 同时记录下当前的max, 时刻更新max.

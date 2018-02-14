/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class PaintHouse {
	public static void main(String[] args) {
		System.out.println();
		int[][] costs = {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println(minCost(costs));
		
	}
	//method1
	public static int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		int n = costs.length - 1;
		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][2], costs[i - 1][0]);
		}
		return Math.min(Math.min(costs[n][0], costs[n][1]),costs[n][2]);
	}
}

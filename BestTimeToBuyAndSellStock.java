/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * get the max profit for a single share, selling must after buying
 */
public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = {1,3,8,4,6};
		System.out.println(getMaxProfit(prices));
	}
	
	public static int getMaxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
		int maxProfit = Integer.MIN_VALUE;
		int buy = prices[0];
		for (int sell : prices) {
			buy = Math.min(buy, sell);
			maxProfit = Math.max(maxProfit, sell - buy);
		}
		return maxProfit;
	}
}

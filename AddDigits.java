/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given 38, 计算3+8=11， 1+1=2， return 2
 */
public class AddDigits {
	public static void main(String[] args) {
		System.out.println(addDigits(129));
	}
	public static int addDigits(int num) {
		int res = 0;
		while (num != 0) {
			int digit = num % 10;
			res += digit;
			num /= 10;
		}
		if (res < 10) {
			return res;
		}
		return addDigits(res);
	}
}
//time: O(n), space: O(n) recursion

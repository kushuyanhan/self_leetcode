/**
 * 
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuemaomao
 * 19 is happy number, 
 *12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
not 1, not happy number, or 出现了循环，
 */
public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(18));
	}
	
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int squareSum, remain;
		while (set.add(n)) {
			squareSum = 0;
			while (n > 0) {
				remain = n % 10;
				squareSum += remain * remain;
				n /= 10;
			}
			if (squareSum == 1) {
				return true;
			} else {
				n = squareSum;
			}
		}
		return false;
	}
}
//time: dont' know, space: O(n)

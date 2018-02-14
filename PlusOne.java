/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 * array 代表一个数字，[1,2,3] 代表123， 加1返回结果, no leading zeros, e.g [0,0,1]
 */
public class PlusOne {
	public static void main(String[] args) {
		int[] digits = new int[]{1,2,9};
		System.out.println(Arrays.toString(plusOne(digits)));
	}
	
	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[]{-1};
		}
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}
}

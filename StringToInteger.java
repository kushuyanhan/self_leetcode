/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given a string, convert it to integer, consider all cases
 * 1) 正负数，2）越界， 3） valid 是否是数字("12v" return 12, "v12" return 0)
 */
public class StringToInteger {
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483649"));
	}
	
	public static int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		str = str.trim();
		int sign = 1;
		long res = 0;
		int start = 0;
		char firstChar = str.charAt(0);
		if (firstChar == '+') {
			sign = 1;
			start++;
		}
		if (firstChar == '-') {
			sign = -1;
			start++;
		}
		for (int i = start; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) { //v12  return 0, //12v return 12
				return (int) res * sign;
			}
			res = res * 10 + str.charAt(i) - '0';
			if (sign == 1 && res > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (sign == -1 && res > Integer.MAX_VALUE) {
				return Integer.MIN_VALUE;
			}
		}
		return (int) res * sign;
	}
}

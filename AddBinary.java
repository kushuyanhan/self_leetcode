/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * "11"+"10" return "100"
 */
public class AddBinary {
	public static void main(String[] args) {
		System.out.println();
	}
	
	public static String addBinary(String a, String b) {
		int i = a.length() - 1, j = b.length() - 1;
		int sum = 0, carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				sum += a.charAt(i) - '0';
			}
			if (j >= 0) {
				sum += b.charAt(j) - '0';
			}
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
}
//time: O(n), space: O(1)
//从后往前相对应的位置进行相加，注意因为是while(i||j), 所以在后面分别判断i, j 的时候要加上判断i, j >=0

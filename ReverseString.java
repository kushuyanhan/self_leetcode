/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class ReverseString {
	public static void main(String[] args) {
		System.out.println();
	}
	public String reverseString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int i = 0, j = s.length() - 1;
		char[] arr = s.toCharArray();
		while (i < j) {
			char c = arr[i];
			arr[i++] = arr[j];
			arr[j] = c;
		}
		return new String(arr);
	}
}
//time: O(n), space: O(n) due to new char array,
//bug: 不能直接用s.charAt(i) = s.charAt(j), why? 因为String is immutable, 必须转化成char array 
//才能swap重新赋值

/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author xuemaomao
 *s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		System.out.println(decodeString(s));
	}
	
	public static String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		Stack<Integer> countStack= new Stack<>();
		Stack<String> resStack = new Stack<>();
		String res = "";
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count += count * 10 + s.charAt(idx) - '0';
					idx++;
				}
				countStack.push(count);
			} else if (s.charAt(idx) == '[') {
				resStack.push(res);
				res = ""; //这里要清空下，否则会累积，3[a]2[bc], 会变成aaa，然后变成aaabc
				idx++;
			} else if (s.charAt(idx) == ']') {
				StringBuilder sb = new StringBuilder(resStack.pop());
				int time = countStack.pop();
				for (int i = 0;i < time; i++) {
					sb.append(res);
				}
				res = sb.toString();
				idx++;
			} else {
				res += s.charAt(idx++);
			}
		}
		return res;
	}
}

/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuemaomao
 *
 */
public class FlipGame {
	public static void main(String[] args) {
		String s = "++++";
		System.out.println(Arrays.asList(flipGame(s)));
		System.out.println(Arrays.asList(flipGame2(s)));
	}
	
	public static List<String> flipGame(String s) {
		List<String> res = new ArrayList<>();
		char[] charArr = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (charArr[i] == '+' && charArr[i + 1] == '+') {
				charArr[i] = '-';
				charArr[i + 1] = '-';
				res.add(new String(charArr));
				charArr[i] = '+';
				charArr[i + 1] = '+';
			}
		}
		return res;
	}
	
	public static List<String> flipGame2(String s) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
				res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
			}
		}
		return res;
	}
}

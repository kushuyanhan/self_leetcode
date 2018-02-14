/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuemaomao
 * "ab","cde" -> 2/ab3/cde
 * 
 */
public class EncodeAndDecodeString {
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("ab","cde");
		
		System.out.println(encode(strs));
		System.out.println(decode(encode(strs)));
	}
	
	public static String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.length()).append("/").append(s);
		}
		return sb.toString();
	}
	
	public static List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			int slash = s.indexOf("/", i); //从i 的位置开始找第一次/的位子，返回
			int size = Integer.valueOf(s.substring(i, slash));
			res.add(s.substring(slash + 1, slash + size + 1));
			i = slash + size + 1;
		}
		return res;
	}
}

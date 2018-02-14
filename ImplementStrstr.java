/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Return the index of first occurence of needle in haystack, or -1 if not found
 */
public class ImplementStrstr {
	public static void main(String[] args) {
		System.out.println(strStr("abcstack", "cs"));
	}
	
	public static int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) {
			return 0;
		}
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = 0;
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}
}
//time: O(mn), space: O(1)
//m is length of haystack, n is length of needle

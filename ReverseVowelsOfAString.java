/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given “opsfaepUio", reverse only vowels, 
 */
public class ReverseVowelsOfAString {
	public static void main(String[] args) {
		String s = "erqaeioadpp";
		System.out.println(reverseVowels(s));
	}
	public static String reverseVowels(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String vowels = "aeiouAEIOU";
		int start = 0, end = s.length() - 1;
	
		char[] chars = s.toCharArray();
		while (start < end) {
			while (start < end && vowels.indexOf(chars[start]) == -1) {
				start++;
			}
			while (start < end && vowels.indexOf(chars[end]) == -1) {
                end--;
            }
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
		return new String(chars);
	}
}

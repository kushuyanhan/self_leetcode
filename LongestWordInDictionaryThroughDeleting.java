/**
 * 
 */
package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xuemaomao
 *
 */
public class LongestWordInDictionaryThroughDeleting {
	public static void main(String[] args) {
		String s = "abpcplea";
		String[] arr = {"ale","apple","monkey","plea"};
		List<String> list = Arrays.asList(arr);

		System.out.println(findLongestWord(s, list));
	}
	
	public static String findLongestWord(String s, List<String> d) {
		Collections.sort(d, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
		for (String word : d) {
			int i = 0; 
			for (char c : s.toCharArray()) {
				if (i < word.length() && c == word.charAt(i)) {
					i++;
				}
				if (i == word.length()) {
					return word;
				}
			}
		}
		return "";
	}
}

/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xuemaomao
 * leetcode500, Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"], output the words which all letters in this words appear in the same row on keyboard
 */
public class KeyboardRow {
	public static void main(String[] args) {
		System.out.println();
	}
	public static String[] findWords(String[] words) {
		Set<Character> set1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
		Set<Character> set2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
		Set<Character> set3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
		List<String> res = new ArrayList<>();
		for (String word : words) {
			int one = 0, two = 0, three = 0;
			for (char c : word.toCharArray()) {
				if (c < 'a') c += 32;
				if (set1.contains(c)) one = 1;
				if (set2.contains(c)) two = 1;
				if (set3.contains(c)) three = 1;
				if (one + two + three > 1) break;
			}
			if (one + two + three == 1) {
				res.add(word);
			}
		}	 
		int index = 0;
		String[] ans = new String[res.size()];
		for (String s : res) {
			ans[index++] = s;
		}
		return ans;
	}
}	
//time: O(n), space:O(n)

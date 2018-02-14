/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuemaomao
 *
 */
public class FirstNonRepeatingCharacter {
	public static void main(String[] args) {
		String s = "abcdee";
		System.out.println(firstNonReapeatingCharacter(s));
	}
	
	public static int firstNonReapeatingCharacter(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), i);
			} else {
				return map.get(s.charAt(i));
			}
		}
		return -1;
	}
}

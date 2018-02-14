/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
 * @author xuemaomao
 *
 */
public class FlipGameii {
	public static void main(String[] args) {
		String s = "++++";
		System.out.println(canWin(s));
	}
	
	public static boolean canWin(String s) {
		HashMap<String, Boolean> map = new HashMap<>();
		return helper(s, map);
	}
	private static boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(opponent, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
	}
}

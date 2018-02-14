/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuemaomao
 * Given "abb", "cdd", is isomorphic, "abb", "cd", not isomorphic
 */
public class IsIsomorphic {
	public static void main(String[] args) {
		//System.out.println(isIsomorphic("abb", "cdd"));
		System.out.println(isIsomorphic2("aab", "ccd"));
	}
//	public static boolean isIsomorphic(String s, String t) {
//		if (s.length() != t.length()) {
//			return false;
//		}
//		Map<Character, Character> map = new HashMap<>();
//		for (int i = 0; i < s.length(); i++) {
//			char a = s.charAt(i);
//			char b = t.charAt(i);
//			if (map.containsKey(a)) {
//				if (map.get(a).equals(b)) {
//					continue;
//				} else {
//					return false;
//				}
//			} else {
//				if (map.containsValue(b)) {
//					return false;
//				} else {
//					map.put(a, b);
//				}
//			}
//		}
//		return true;
//	}
//	
	//method2
	public static boolean isIsomorphic2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] sChar = new int[256];
		int[] tChar = new int[256];
		for (int i = 0; i < s.length(); i++) {
			if (sChar[s.charAt(i)] != tChar[t.charAt(i)]) {
				return false;
			} else {
				sChar[s.charAt(i)] = i + 1;
				tChar[t.charAt(i)] = i + 1;
			}	
		}
		return true;
	}
}
//"aab"->"cdd"  s['a'] = 1, t['c'] = 1, s['a'] = 2, t['d'] =0
//"aab"->"ccd" s['a'] = 0, t['a'] = 0, 

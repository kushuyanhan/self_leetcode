/**
 * 
 */
package leetcode;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @author xuemaomao
 *	Given ["eat", "tea", "tan", "ate", "nat", "bat"]
 *return [
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
All input lowercase
 */
public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = {"eat", "eat", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
		System.out.println(groupAnagrams2(strs));
	}
	//method1: time: O(mnlogn), space: O(n)
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<ArrayList<String>>(map.values());
	}
	
	//method2: time: O(mn), space: O(n)
	public static ArrayList<ArrayList<String>> groupAnagrams2(String[] strs) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
        	int[] count = new int[26]; //all lower case 
        	for (Character ch : str.toCharArray()) {
        		count[ch - 'a']++;
        	}
        	String s = "";
        	for (int i = 0; i < count.length; i++) {
        		if (count[i] != 0) {
        			s += String.valueOf(count[i]) + String.valueOf((char) (i + 'a'));
        		}
        	}
        	if (map.containsKey(s)) {
        		ArrayList<String> list = map.get(s);
        		list.add(str);
        	} else {
        		ArrayList<String> list = new ArrayList<>();
        		list.add(str);
        		map.put(s, list);
        	}
        }
        return new ArrayList<>(map.values());
	}
        
}

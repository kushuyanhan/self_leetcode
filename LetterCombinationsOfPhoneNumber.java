package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LetterCombinationsOfPhoneNumber {
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	public static void main(String[] args) {
		ArrayList<String> res = (ArrayList<String>) letterCombinations("23");
		//ArrayList<String> res = (ArrayList<String>) letterCombinations3("23");
		System.out.println(res.toString());
	}
	 //method1 dfs
    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(res, digits, "", 0);
        return res;
    }
    public static void helper(ArrayList<String> res, String digits, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String letters = KEYS[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i), index + 1);
        }
    }


    //bfs better version for bfs
    public static List<String> letterCombinations3(String digits) {
    	LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int cur = digits.charAt(i) - '0';
            while (res.peek().length() == i) { //res.的第一个元素的长度==i来判断层数
                String t = res.remove();
                char[] candidates = mapping[cur].toCharArray();
                for (char s : candidates) {
                    res.add(t + s);
                }
            }
        }
        return res;
      }
}
//bf 的过程是先把a, b， c加入，然后再给每个字母a,b,c 配上d, e,f
    //[a, b, c]
    //[ad, ae, af, bd,be, bf, cd, ce, cf]
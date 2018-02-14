package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
	public static void main(String[] args) {
		List<Integer> res = findAnagrams("abcba", "ab");
		System.out.println(res.toString());
	}
	public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        int[] m = new int[256];
        int[] n = new int[256];
        for (int i = 0; i < p.length(); i++) {
            m[p.charAt(i)]++;
            n[s.charAt(i)]++;
        }
        if (Arrays.equals(m, n)) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            n[s.charAt(i)]++;
            n[s.charAt(i - p.length())]--;
            if (Arrays.equals(m, n)) res.add(i - p.length() + 1);
        }
        return res;
    }
}

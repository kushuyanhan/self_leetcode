package leetcode;

public class RepeatedSubstringPattern {
	 public static void main(String[] args) {
		 System.out.println(repeatedSubstringPattern("abab"));
	 }
	 public static boolean repeatedSubstringPattern(String s) {
	        if (s == null || s.length() == 0) {
	            return false;
	        }
	        int n = s.length();
	        for (int i = n / 2; i >= 1; i--) {
	            if (n / i == 0) {
	                int cnt = n / i;
	                String t = "";
	                for (int j = 0; j < cnt; j++) {
	                    t += s.substring(0, i);
	                }
	                if (t.equals(s)) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
}

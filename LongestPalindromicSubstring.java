package leetcode;

public class LongestPalindromicSubstring {
	private static String res = "";
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}
	
	 public static String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)) {
            	return s;
            } else {
            	return s.substring(1);
            }
        }
        int maxStart = 0;
        int maxEnd = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++){
            int start = i - 1;
            while(start >= 0 && s.charAt(start) == s.charAt(i)) {
            	start --;
            }

			int end = i + 1;
			while(end < s.length() && s.charAt(end) == s.charAt(i)) {
				end++;
			}
			while(start >= 0 && end < s.length()){
			    if(s.charAt(start) == s.charAt(end)){
			    	start --;
			        end ++;
			    } else {
			    	break; 
		    	}
			}
			if(end - start - 1 > maxLength) {
			    maxLength = end - start - 1;
			    maxStart = start + 1;
			    maxEnd = end - 1;
			}
		}
        return s.substring(maxStart, maxEnd + 1);
	}
}

//
//    public static String longestPalindrome(String s) {
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            helper(s, i, i); //bab 奇数
//            helper(s, i, i + 1); //bb 偶数
//        }
//        return res;
//    }
//    public static void helper(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//        String cur = s.substring(left + 1, right);
//        if (cur.length() > res.length()) {
//            res = cur;
//        }
//    }
//}
//time: O(n^2), space: O(1)

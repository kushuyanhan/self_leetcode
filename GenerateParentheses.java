package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		System.out.println(generateParenthesis2(2));
	}
//	
	public static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;
    }
    public static void helper(List<String> res, String s, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > left) {
            helper(res, s + ")", left, right - 1);
        }
    }
    
//	 public static List<String> generateParenthesis(int n) {
//	    List<String> list = new ArrayList<String>();
//	    dfs(list, new StringBuilder(), n, n);
//	    return list;
//	 }
//	 private static void dfs(List<String> list, StringBuilder sb, int left, int right){
//	    if(left == 0 && right == 0){
//	        list.add(sb.toString());
//	        return;
//	    }
//	    int length = sb.length();
//	    if(left > 0){
//	        sb.append('(');
//	        dfs(list, sb, left - 1, right);
//	        sb.setLength(length);
//	    }
//	    if(right > left){
//	        sb.append(')');
//	        dfs(list, sb, left, right - 1);
//	        sb.setLength(length);
//	    }
//	}
}
//	public static void helper2(List<String> res,  String s, int n, int left, int right) {
//		if (right == n) {
//			res.add(s);
//			return;
//		}
//		if (left < n) {
//			helper2(res, s + "(", n, left + 1, right);
//		}
//		if (right < left) {
//			helper2(res, s + ")", n, left, right + 1);
//		}
//	}
//}
//time: O(2^n), space: O(n) due to recursion on stack
//n = 3, 
//((())),(()()), (())(), ()(()), ()()()
//这道题给定一个数字n，让生成共有n个括号的所有正确的形式，
//method1
//对于这种列出所有结果的题首先还是考虑用递归Recursion来解，由于字符串只有左括号和右括号两种字符，
//而且最终结果必定是左括号3个，右括号3个，所以我们定义两个变量left和right分别表示剩余左右括号的个数，
//如果在某次递归时，左括号的个数大于右括号的个数，说明此时生成的字符串中右括号的个数大于左括号的个数，
//即会出现')('这样的非法串，所以这种情况直接返回，不继续处理。如果left和right都为0，
//则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。
//如果以上两种情况都不满足，若此时left大于0，则调用递归函数，注意参数的更新，
//若right大于0，则调用递归函数，同样要更新参数

//记住回溯的时候先以左括号优先
//method2
//算法： 当left < n 的时候，left+1, 当right < left 的时候， right+1, 当right==n 的时候，一个匹配成功的放入结果集

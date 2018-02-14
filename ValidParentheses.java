/**
 * 
 */
package leetcode;

import java.util.Stack;

/**
 * @author xuemaomao
 * Given a string e.g "({)" return valid or not
 */
public class ValidParentheses {
	public static void main(String[] args) {
		String s = "()}";
		System.out.println(isValid(s));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || stack.pop() != c){
				return false;
			}
		}
		return stack.isEmpty();
	}
}
//time: O(n), space: O(n)
//2bugs:
//1) 最后判断stack.isEmpty() 是为了检验左括号是否有多余
//2) else if () stack.isEmpty() 是为了检验右括号是否有多余

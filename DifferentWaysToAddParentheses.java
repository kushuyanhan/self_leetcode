/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuemaomao
 *
 */
public class DifferentWaysToAddParentheses {
	public static void main(String[] args) {
		List<Integer> res = diffWaysToCompute("1-2*2");
		System.out.println(res);
	}
	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				String part1 = input.substring(0, i);
				String part2 = input.substring(i + 1);
				List<Integer> part1ret = diffWaysToCompute(part1);
				List<Integer> part2ret = diffWaysToCompute(part2);
				for (Integer a : part1ret) {
					for (Integer b : part2ret) {
						int p = 0;
						  switch (c) {
							case '+':
								p = a + b;
								break;
							case '-':
								p = a - b;
								break;
							case '*':
								p = a * b;
								break;
						  }
						  res.add(p);
					}
				}
				
			}
		}
		//single nubmer ,eg 3
		if (res.size() == 0){
			res.add(Integer.valueOf(input));
		}
		return res;
	}
}
//time: O(n^3), space: O(n)

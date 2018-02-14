/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuemaomao
 *
 */
public class LexicographiicalNumbers {
	public static void main(String[] args) {
		System.out.println(lexicalOrder(24));
	}
	
	public static List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		int cur = 1;
		for (int i = 1; i <= n; i++) {
			res.add(cur);
			if (cur * 10 <= n) {
				cur *= 10;
			} else if (cur % 10 != 9 && cur + 1 <= n) {
				cur++;
			} else {
				while ((cur / 10) % 10 == 9) { //199 这种情况下一个是2， 需要这个处理
					cur /= 10;
				}
				cur = cur / 10 + 1;
			}
		}
		return res;
	}
}
//time: O(n), space: O(n)

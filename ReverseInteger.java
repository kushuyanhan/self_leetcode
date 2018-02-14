/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(-321));
	}
	
	public static int reverse(int x) {
		long res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
		}
		return (int)res;
	}
}
//time: O(n), space: O(1)
//-123 翻转是-321, 所以while (x!=0), 而不是x>0
//reverse 后可能越界，所以用res

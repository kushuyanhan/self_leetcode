/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given a sentence, valid palindrome or not, consider only digit and Character, 
 * ignore cases
 */
public class ValidPalindrome {
	public static void main(String[] args) {
		System.out.println();
	}
	
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
//time: O(n), space: O(1)

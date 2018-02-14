/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 * Given a string, you need to reverse the order of characters 
 * in each word within a sentence while still preserving 
 * whitespace and initial word order.
 * 每个单词中间只有一个space, 而且整个string 没有多余的spaces.
 * 只是翻转每个单词本身，"we are fine"->"ew era enif"
 * 
 * 另外一个题是， "we are fine" -> "fine are we"
 */
public class ReverseWordsInAString {
	public static void main(String[] args) {
		String s = "we are fine";
		System.out.println(reverseWords(s));
	}
	
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		char[] arr = s.toCharArray();
		//reverse(arr, 0, arr.length - 1); //对于另外一个题，就是多加了这一行，先把整个string 翻转，然后再每个单词翻转
		int i = 0;
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == ' ') {
				reverse(arr, i, j - 1);
				i = j + 1;
			}
		}
		reverse(arr, i, arr.length - 1);
		return String.valueOf(arr);
	}

	
	private static void reverse(char[] arr, int i, int j) {
		while (i < j) {
			char c = arr[i];
			arr[i++] = arr[j];
			arr[j--] = c;
		}
	}
}
//time: O(n), space: O(n)

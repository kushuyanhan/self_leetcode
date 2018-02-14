/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class WordSearch {
	public static void main(String[] args) {
		System.out.println();
		char[][] board = {{'a','b'},{'d','c'}};
		System.out.println(exist(board, "abc"));
	}
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (word.charAt(0) == board[i][j]) {
					boolean rst = search(board, word, i, j, 0);
					if (rst) {
						return true;
					}
				}
			}
		}
		return false;
	}
	private static boolean search(char[][] board, String word, int i, int j, int index) {
		if (index == word.length()) {
			return true;
		}
		if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index)) {
			return false;
		}
		board[i][j] = '*';
		boolean rst = search(board, word, i + 1, j, index + 1) 
					|| search(board, word, i, j + 1, index + 1)
					|| search(board, word, i - 1, j, index + 1)
					|| search(board, word, i, j - 1, index + 1);
		//board[i][j] = word.charAt(index);
		return rst;
					
	}
}

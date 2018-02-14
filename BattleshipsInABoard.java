/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class BattleshipsInABoard {
	public static void main(String[] args) {
		char[][] board = {{'x','.','.','x'},{'.','.','.','x'},{'.','.','.','x'}};
		System.out.println(countBattleships(board));
	}
	
	private static int countBattleships(char[][] board) {
		int m = board.length, n = board[0].length;
		if (m == 0) return 0;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (i > 0 && board[i - 1][j] == 'x') {
					continue;
				}
				if (j > 0 && board[i][j - 1] == 'x') {
					continue;
				}
				count++;
			}
		}
		return count;
	}
}
//time: O(n^2), space: O(1)

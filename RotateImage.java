/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class RotateImage {
	public static void main(String[] args) {
		System.out.println();
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotateImage(matrix);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void rotateImage(int[][] matrix) {
		//diagonal
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	
//		//vertical line
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}
	private static void swap(int[][] nums, int i, int j) {
		int temp = nums[i][j];
		nums[i][j] = nums[j][i];
		nums[j][i] = temp;
	}
		
}

/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 * Move zeros to the left, while maintaining the order of the non-zero element.
 */
public class MoveZerosToLeft {
	public static void main(String[] args) {
		int[] arr = {1,3,0,8,0,5,9};
		int[] res = moveZerosToLeft(arr);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] moveZerosToLeft(int[] arr) {
		if (arr == null || arr.length == 0) {
			return new int[]{-1};
		}
		int index = arr.length - 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				arr[index--] = arr[i];
			}
		}
		while (index >= 0) {
			arr[index--] = 0;
		}
		return arr;
	}
}

/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 * Given an array, [0,1,0,3,12], return [1,3,12,0,0]
 * main relative order of non zeroes elements
 * in place without copy of the array
 * 最少次数的操作
 */
public class MoveZeroes {
	public static void main(String[] args) {
		int[] arr = new int[]{0,1,0,3,12};
		moveZeroes(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void moveZeroes(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[index++] = arr[i];
			}
		}
		while (index < arr.length) {
			arr[index++] = 0;
		}
	}
}

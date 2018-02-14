package leetcode;

import java.util.Arrays;
import java.util.Random;

class Solution {
	private int[] nums;
	private Random r;
	
	public Solution(int[] nums) {
		this.nums = nums;
		r = new Random();
	}
	
	public int[] reset() {
		return nums;
	}
	
	public int[] shuffle() {
		if (nums == null) {
			return null;
		}
		int[] clone = nums.clone();
		for (int j = 1; j < clone.length; j++) {
			int i = r.nextInt(j + 1);
			swap(clone, i, j);
		}
		return clone;
	}
    private void swap(int[] clone, int i, int j) {
        int temp = clone[i];
		clone[i] = clone[j];
		clone[j] = temp;
    }   
}
public class ShuffleAnArray {
	public static void main(String[] args) {
		//System.out.println();
		int[] nums = {1, 2, 3};
		Solution sol = new Solution(nums);
		int[] p1 = sol.reset();
		int[] p2 = sol.shuffle();
		System.out.println(Arrays.toString(p1));
		System.out.println(Arrays.toString(p2));
		
	}
}

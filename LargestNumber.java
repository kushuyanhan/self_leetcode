package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public static void main(String[] args) {
		int[] nums = {9, 30, 45};
		String res = largestNumber(nums);
		
		System.out.println(res);
	}
	
	public static String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] res = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(res, new Comparator<String>(){
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		});
		
		if (res[0].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String s : res) {
			sb.append(s);
		}
		//System.out.println(sb.toString());
		return sb.toString();
	}
}

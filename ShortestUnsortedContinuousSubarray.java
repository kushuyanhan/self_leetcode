package leetcode;

public class ShortestUnsortedContinuousSubarray {
	public static void main(String[] args) {
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		System.out.println(findUnsortedSubarray(nums));
	}


	public static int findUnsortedSubarray(int[] nums) {
	    if (nums == null || nums.length == 0) {
	        return -1;
	    }
	    return 0;
	}
	  
}

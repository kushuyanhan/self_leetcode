package leetcode;

public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = {1,3,5};
		int target = 5;
		boolean res = SearchInRotatedSortedArray(nums, 5);
		System.out.println(res);
	}
	public static boolean SearchInRotatedSortedArray(int[] nums, int target) {
		
		if (nums == null || nums.length == 0) {
	        return false;
	    }
	    int start = 0, end = nums.length - 1;
	    while (start + 1 < end) {
	        int mid = start + (end - start) / 2;
	        if (nums[mid] == target) {
	            return true;
	        }
	        if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
	            start++;
	            end--;
	        } else if (nums[start] < nums[mid]) {
	            if (nums[start] <= target && target <= nums[mid]) {
	                end = mid;
	            } else {
	                start = mid;
	            }
	        } else {
	            if (nums[mid] <= target && target <= nums[end]) {
	                start = mid;
	            } else {
	                end = mid;
	            }
	        }
	    }
	    if (nums[start] == target) {
	        return true;
	    }
	    if (nums[end] == target) {
	        return true;
	    }
	    return false;
     }
}
//time: O(logn), space: O(1)

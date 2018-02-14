package leetcode;

public class QuickSelect {
	public static void main(String[] args) {
		int[] nums = new int[]{9,3,2,4,8};
		int res = kthLargestElement(3, nums);
		System.out.println(res);
	}
	public static int kthLargestElement(int k, int[] nums) {
        // write your code here
        //quick select
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private static int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) { //
            return nums[start];
        }
        int i = start, j = end;
        int pivot = nums[(i + j) / 2];
        
        while (i <= j) {
            while (i <= j && nums[i] > pivot) {
                i++;
            }
            while (i <= j && nums[j] < pivot) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        
        System.out.println(i + "-" + j);
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        return nums[j + 1];   
    }
}
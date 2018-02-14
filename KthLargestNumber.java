package leetcode;
//求的是排好序后的第k大的数字，包括重复的数字，不是distinct number.,
public class KthLargestNumber {
	public static void main(String[] args) {
		int[] nums = {3,5,1,7,7,6,9};
		int k = 3;
		int res = kthLargestNumber2(nums, 3); //return 7
		System.out.println(res);
	}
	public static int kthLargestElement(int k, int[] nums) {
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
        if (start + k - 1 <= j) {
            return quickSelect(nums, start, j, k);
        }
        if (start + k - 1 >= i) {
            return quickSelect(nums, i, end, k - (i - start));
        }
        return nums[j + 1];
    }
    
    
    //another way for quick select
    public static int kthLargestNumber2(int[] nums, int k) {
    	return partition(nums, k, 0, nums.length - 1);
    }
    
    private static int partition(int[] nums, int k, int start, int end) {
    	int pivot = nums[start];
    	int left = start;
    	int right = end;
    	
    	while (left <= right) {
    		while(left <= right && nums[left] >= pivot) left++;
            while(left <= right && nums[right] <= pivot) right--;
            
            if(left < right) swap(nums, left, right);
    	}
        swap(nums, start, right);
        if(k == right + 1) return nums[right];
        if(k > right + 1){
            return partition(nums, k, right + 1, end);
        } else {
            return partition(nums, k, start, right - 1);
        }
    }
    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;	
    } 
}
//average time: O(n)

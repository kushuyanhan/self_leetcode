/**
 * 
 */
package leetcode;

/**
 * @author xuemaomao
 *
 */
public class Xcode {
	   /**
     * Kth Largest Element in an Array
     * 
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
For example,
Given [3,2,1,5,6,4] and k = 2, return 5. 
[3,3,3,3] and k = 1, return 3.
O(N) guaranteed running time + O(1) space

So how can we improve the above solution and make it O(N) guaranteed? The answer is quite simple,
we can randomize the input, so that even when the worst case input would be provided the algorithm wouldn't be affected.
So all what it is needed to be done is to shuffle the input.

This is QuickSelect from QuickSort.
     */
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index) {
                start = pivot + 1;
            } else if (pivot > index) {
                end = pivot - 1;
            } else {
                return nums[pivot];
            }
        }

        // sample input: [1]
        return nums[start];
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) {
                start++;
            }
            while (start <= end && nums[end] > nums[pivot]) {
                end--;
            }
            if (start > end) {
                break;
            }
            swap(nums, start, end);
        }
        swap(nums, end, pivot);
        return end;
    }
    
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    /**
     * Sort Colors
     * Given an array with n objects colored red, white or blue,
     * sort them so that objects of the same color are adjacent, with the colors
     * in the order red, white and blue. Here, we will use the integers 0, 1,
     * and 2 to represent the color red, white, and blue respectively. A rather
     * straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then
     * overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with an one-pass algorithm using only constant space?
     */
    public void sortColors(int[] nums) {
        // If nums is very big, it is likely to often hit page default by loading
        // three sections of nums (l,m,r) and cause thrashing
        int l = 0;
        int r = nums.length - 1;
        for (int m = 0; m <= r;) {
            if (nums[m] == 0) {
                swap(nums, l++, m++);
            } else if (nums[m] == 2) {
                swap(nums, r--, m);
            } else {
                m++;
            }
        }
    }
    
    /**
     * Wiggle Sort
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
Greedy */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && (nums[i] < nums[i - 1])) || (i % 2 == 0) && (nums[i] > nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    } 

    /**
     * Wiggle Sort II
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Can you do it in O(n) time and/or in-place with O(1) extra space? 
     */
    public void wiggleSort2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int median = findKthLargest(nums, (nums.length + 1) >>> 1);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;
        // The index mapping, (1 + 2*index) % (n | 1) combined with 'Color sort'
        while (i <= right) {
            int index = newIndex(i, n);
            if (nums[index] > median) {
                swap(nums, newIndex(left++, n), index);
                i++;
            } else if (nums[index] < median) {
                swap(nums, newIndex(right--, n), index);
            } else {
                i++;
            }
        }
    }

    // n = 6 => [1 3 5 0 2 4], 6 | 1 => 7
    // n = 7 => [1 3 5 0 2 4 6], 7 | 1 => 7
    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    /**
     * Wiggle Subsequence
A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
Examples:

Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2

O(n) greedy solution
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {    
            return nums.length;
        }
        int k = 0;
        // Skips all the same number from series beginning, e.g. 5, 5, 5, 1
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) { 
            k++;
        }
        if (k == nums.length - 1) {
            return 1;
        }
        int result = 2; // This will track the result of result array
        // To check series starting pattern
        boolean prevInc = nums[k] < nums[k + 1];
        for (int i = k + 1; i < nums.length - 1; i++) {
            if ((prevInc && nums[i + 1] < nums[i]) || (!prevInc && nums[i + 1] > nums[i])) {
                // modify the same 'nums' array to store the (small, big, small) hill shape values
                nums[result++] = nums[i + 1];
                prevInc = !prevInc;
            }
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

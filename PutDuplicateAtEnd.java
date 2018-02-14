/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 *
 */
public class PutDuplicateAtEnd {
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,2,3,3,4,4};
		putDuplicateAtEnd(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void putDuplicateAtEnd(int[] arr) {
		//1112223344 ->1234112234
		int i = 0;
	    for(int j = 1; j < arr.length; j++) {
	       if (arr[i] == arr[j]) {
	    	  continue;
	       } else {
	          i++;
	          int temp = arr[i];
	          arr[i] = arr[j];
	          arr[j] = temp;
	       }
	    }
	}
}

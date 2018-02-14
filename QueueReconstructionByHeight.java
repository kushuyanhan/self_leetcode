/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xuemaomao
 *
 */
public class QueueReconstructionByHeight {
	public static void main(String[] args) {
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] res = queueReconstruct(people);
		System.out.println(Arrays.deepToString(res));
	}
	public static int[][] queueReconstruct(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][0];
		}
		
		List<int[]> res = new ArrayList<>();
//		Arrays.sort(people, new Comparator<int[]>(){
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// TODO Auto-generated method stub
//				return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
//			}
//			
//		});
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
		for (int[] cur : people) {
			res.add(cur[1], cur);
		}
		
		return res.toArray(new int[people.length][]);
	}
}
//time: O(n^2), space: O(n);
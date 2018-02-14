/**
 * 
 */
package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author xuemaomao
 * [3, 8],[2, 5],[1, 4],[9, 10] merge overlapping 
 * return [1,8][9,10]
 */

class Interval {
	int start;
	int end;
	public Interval() {
		this.start = 0;
		this.end = 0;
	}
	public Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}
public class MergeIntervals {
	public static void main(String[] args) {
		Interval i1 = new Interval(3, 8);
		Interval i2 = new Interval(2, 5);
		Interval i3 = new Interval(1, 4);
		Interval i4 = new Interval(9, 10);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		
		List<Interval> res = merge(intervals);	
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + "-" + res.get(i).end);
		}
		System.out.println();
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}
//		Collections.sort(intervals, new Comparator<Interval>(){
//			public int compare(Interval a , Interval b) {
//				return a.start - b.start;
//			}
//		});
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		Interval last = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (cur.start <= last.end) {
				last.end = Math.max(last.end, cur.end);
			} else {
				res.add(last);
				last = cur;
			}
		}
		res.add(last);
		return res;
	}
}

/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author xuemaomao
 * Given a list of intervals, return the maximum number of intervals, which are non-overlapping
 * [1,3],[2,5],[4,6],[8,9]
 * return [1,3][4,6][8,9] this is 3 intervals maximum.
 */
public class MaximumIntervals {
	public static void main(String[] args) {
		Interval interval1 = new Interval(1,5);
		Interval interval2 = new Interval(2,4);
		Interval interval3 = new Interval(3,7);
		Interval interval4 = new Interval(8,9);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		List<Interval> res = maxIntervals(intervals);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + "-" + res.get(i).end);
		}	
	}
	
	public static List<Interval> maxIntervals(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null || intervals.size() == 0) {
			return res;
		}
		Collections.sort(intervals, (a, b) -> (a.start - b.start));
		
		Interval last = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).end < last.end) {
				last = intervals.get(i);
				continue;
			}
			if (intervals.get(i).start > last.end) {
				res.add(last);
				last = intervals.get(i);
			}
		}
		res.add(last);
		return res;
	}
}

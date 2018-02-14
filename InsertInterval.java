/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuemaomao
 *
 */

public class InsertInterval {
	public static void main(String[] args) {
		Interval newInterval = new Interval(4,9);
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		List<Interval> res = insertInterval(intervals, newInterval);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i).start + "-" + res.get(i).end);
		}
		//System.out.println(Arrays.toString(insertInterval(intervals, newInterval).toArray()));
	}
	public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<>();
		if (intervals == null) {
			return res;
		}
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			res.add(intervals.get(i++));
		}
		while (i < intervals.size() && intervals.get(i).start < newInterval.end) {
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
			System.out.println(newInterval.start);
			System.out.println(newInterval.end);
			i++;
		}
		res.add(newInterval);
		while (i < intervals.size()) {
			res.add(intervals.get(i++));
		}
		return res;
		
	}
}

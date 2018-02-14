/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 *
 */
public class MeetingRooms {
	public static void main(String[] args) {
		System.out.println();
		Interval i1 = new Interval(0, 3);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] intervals = new Interval[3];
		intervals[0] = i1;
		intervals[1] = i2;
		intervals[2] = i3;
		System.out.println(canAttendMeetings(intervals));
	}
	public static boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null) {
			return false;
		}
		Arrays.sort(intervals, (a, b) -> a.start - b.start);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
 		}
		return true;
	}
}
//time: O(nlogn) due to sorting, space: O(1)

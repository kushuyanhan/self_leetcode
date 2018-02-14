/**
 * 
 */
package leetcode;

import java.util.Arrays;

/**
 * @author xuemaomao
 * Given [[0, 30],[5, 10],[15, 20]],
return 2.
数组表示的是每个meeting 的start, end， return minimum meeting rooms.
 */
public class MeetingRoomsii {
	public static void main(String[] args) {
		System.out.println();
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		Interval[] intervals = new Interval[3];
		intervals[0] = i1;
		intervals[1] = i2;
		intervals[2] = i3;
		System.out.println(minMeetingRooms(intervals));
	}
	public static int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			starts[i] = intervals[i].start;
			ends[i] = intervals[i].end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		int rooms = 0, endItr = 0;
		for (int i = 0; i < starts.length; i++) {
			if (starts[i] < ends[endItr]) {
				rooms++;
			} else {
				endItr++;
			}
		}
		return rooms;
	}
}
//time: O(nlogn), space: O(n)

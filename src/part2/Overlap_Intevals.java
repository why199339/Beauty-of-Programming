package part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Overlap_Intevals {

	public static void main(String[] args) {

	}

	public static boolean isOverlap(Interval target, List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return false;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start != o2.start) {
					return o1.start - o2.start;
				}
				return o1.end - o2.end;
			}
		});
		ArrayList<Interval> list = new ArrayList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval interval : intervals) {
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				list.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		list.add(new Interval(start, end));
		for (Interval interval : list) {
			if (interval.start >= target.start) {
				if (interval.end >= target.end) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// method 2: in-place
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}

		// sort the list in acsending order with a new comparator
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				// if not equal, compare two intervals by start value
				if (i1.start != i2.start) {
					return i1.start - i2.start;
				}

				// if equal, compare intervals by end value
				return i1.end - i2.end;
			}
		});

		ListIterator<Interval> itr = intervals.listIterator();
		Interval cur = itr.next();
		while (itr.hasNext()) {
			Interval next = itr.next();
			if (cur.end < next.start) {
				cur = next;
				continue;
			} else {
				cur.end = Math.max(cur.end, next.end);
				itr.remove();
			}
		}

		return intervals;
    }
}
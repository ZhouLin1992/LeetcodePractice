/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// method1: extra space
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) {
			return intervals;
		}

		// sort the list in acsending order with a new comparator
		// Collections.sort is a modified merge-sort, takes O(NlogN)
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


		List<Interval> res = new ArrayList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		// traverse the whole list
		for (Interval it: intervals) {
			// two intervals overlap, update end value
			if (it.start <= end) {
				end = Math.max(end, it.end);
			} else {
				// two intervals do not overlap, add new interval to result
				res.add(new Interval(start, end));
				start = it.start;
				end = it.end;
			}
		}

		// add last interval
		res.add(new Interval(start, end));
		return res;
    }
}
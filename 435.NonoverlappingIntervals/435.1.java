/*
Greedy, sorting on start point
Time: o(NlogN)
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        
        List<Interval> temp = new LinkedList<>();
        for (int[] interval : intervals) {
            Interval curr = new Interval(interval[0], interval[1]);
            temp.add(curr);
        }
        Collections.sort(temp, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        int res = 0;
        int end = temp.get(0).end;
        
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i).start < end) {
                end = Math.min(temp.get(i).end, end);
                res++;
            } else {
                end = temp.get(i).end;
            }
        }
        
        return res;
    }
}

class Interval {
    int start;
    int end;
    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}
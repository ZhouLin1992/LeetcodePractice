/*
Greedy, sorting on start point
Time: o(NlogN)
这道题给了我们一堆区间，让求需要至少移除多少个区间才能使剩下的区间没有重叠，那么首先要给区间排序，
根据每个区间的 start 来做升序排序，然后开始要查找重叠区间，判断方法是看如果前一个区间的 end 
大于后一个区间的 start，那么一定是重复区间，此时结果 res 自增1，我们需要删除一个，那么此时究竟
该删哪一个呢，为了保证总体去掉的区间数最小，我们去掉那个 end 值较大的区间，而在代码中，我们并没有
真正的删掉某一个区间，而是用一个变量 last 指向上一个需要比较的区间，我们将 last 指向 end 值较
小的那个区间；如果两个区间没有重叠，那么此时 last 指向当前区间，继续进行下一次遍历
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
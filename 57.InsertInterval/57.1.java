class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        
        List<int[]> temp = new LinkedList<>();
        int i = 0;
        
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            temp.add(intervals[i++]);
        }
        
        int[] nextInterval = new int[] {newInterval[0], newInterval[1]};
        while (i < intervals.length && intervals[i][0] <= nextInterval[1]) {
            nextInterval[0] = Math.min(intervals[i][0], nextInterval[0]);
            nextInterval[1] = Math.max(intervals[i][1], nextInterval[1]);
            i++;
        }
        
        temp.add(nextInterval);
        while (i < intervals.length) {
            temp.add(intervals[i++]);
        }
        
        return temp.toArray(new int[temp.size()][2]);
    }
}
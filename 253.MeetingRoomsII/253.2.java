/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int end = 0;
        
        for (int start = 0; start < len; start++) {
            // the new meeting cannot take the existing rooms
            if (starts[start] < ends[end]) {
                rooms++;
            } else {
                end++;
            }
        }
        
        return rooms;
    }
}
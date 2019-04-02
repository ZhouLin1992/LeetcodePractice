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
        
        // sort the input intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval it1, Interval it2) {
                return it1.start - it2.start;
            }
        });
        
        Queue<Integer> queue = new PriorityQueue<>();
        // add the first meeting
        queue.offer(intervals[0].end);

        // iterate over remaining meetings
        for (int i = 1; i < intervals.length; i++) {
            // if there is a room can be freed up, assign the room to the current meeting
            if (queue.peek() <= intervals[i].start) {
                queue.poll();
            }
            /* 
            if a new room is assigned to the current meeting, then we add it to the heap; if an old room is allocated to the current meeting, then we also need to add it to the heap
            */
            queue.offer(intervals[i].end);
        }
        
        // the size of the room is the min number of room for all meetings
        return queue.size();
    }
}
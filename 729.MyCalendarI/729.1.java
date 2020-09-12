// https://leetcode.com/problems/my-calendar-ii/discuss/109519/javac-clean-code-with-explanation
class MyCalendar {
    private List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();        
    }
    
    public boolean book(int start, int end) {
        for (int[] booking: bookings) {
            if (Math.max(start, booking[0]) < Math.min(end, booking[1])) {
                return false;
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
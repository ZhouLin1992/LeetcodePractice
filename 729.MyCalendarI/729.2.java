class MyCalendar {
    TreeSet<int[]> bookings;

    public MyCalendar() {
        bookings = new TreeSet<>((int[] a, int[] b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        int[] booking = new int[]{start, end};
        int[] floor = bookings.floor(booking);
        int[] ceiling = bookings.ceiling(booking);
        
        if (floor != null && start < floor[1]) {
            return false;
        }
        
        if (ceiling != null && ceiling[0] < end) {
            return false;
        }
        
        bookings.add(booking);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
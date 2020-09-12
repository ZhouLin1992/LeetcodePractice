class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0 || capacity <= 0) {
            return false;
        }
        
        Arrays.sort(trips, Comparator.comparing(trip -> trip[1]));
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(trip -> trip[2]));
        
        for (int[] trip : trips) {
            while (!queue.isEmpty() && trip[1] >= queue.peek()[2]) {
                capacity += queue.poll()[0];
            }
            capacity -= trip[0];
            if (capacity < 0) {
                return false;
            }
            queue.offer(trip);
        }

        return true;
    }
}
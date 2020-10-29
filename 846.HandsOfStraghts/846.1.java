class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0 || hand.length < W) {
            return false;
        }
        
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : hand) {
            queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int j = 1; j < W; j++) {
                if (!queue.remove(cur + j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
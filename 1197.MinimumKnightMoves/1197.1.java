class Solution {
    private final int[][] dirs = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == x && curr[1] == y) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int dx = curr[0] + dir[0];
                    int dy = curr[1] + dir[1];
                    String str = dx + "," + dy;
                    /**
                    Since the adjusted target is in the first quadrant, 
                    we'd like to explore towards that direction rather than the opposite. 
                    So whenever there's a step that lies <= (-2, -2), we'd like to stop 
                    exploring that direction to save time.

                    要达到(-1, -1) 最快两步可以达到；如果不允许[-1, -1]，可能需要比2两步更多:(0,0)->(1,2)->(2,0)->(3,2)->(1,1)
                    **/
                    if (!visited.contains(str) && dx >= -1 && dy >= -1) {
                        visited.add(str);
                        queue.offer(new int[]{dx, dy});
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}
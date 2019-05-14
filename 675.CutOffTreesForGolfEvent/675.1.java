class Solution {
    private int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return 0;
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int r = 0; r < forest.size(); r++) {
            for (int c = 0; c < forest.get(r).size(); c++) {
                if (forest.get(r).get(c) > 1) {
                    pq.add(new int[]{r, c, forest.get(r).get(c)});
                }
            }
        }
        
        int minSteps = 0;
        int[] start = new int[2];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int steps = getMinStep(forest, start, curr);
            
            if (steps < 0) {
                return -1;
            }
            
            minSteps += steps;
            start[0] = curr[0];
            start[1] = curr[1];
        }
        
        return minSteps;
    }
    
    private int getMinStep(List<List<Integer>> forest, int[] start, int[] dest) {
        int rows = forest.size();
        int cols = forest.get(0).size();
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int steps = 0;
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == dest[0] && curr[1] == dest[1]) {
                    return steps;
                }

                for (int j = 0; j < 4; j++) {
                    int r = curr[0] + dirs[j][0];
                    int c = curr[1] + dirs[j][1];
                    
                    if (r < 0 || r >= rows || c < 0 || c >= cols || forest.get(r).get(c) == 0 || visited[r][c]) {
                        continue;
                    }
                    
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
            steps++;
        }
        
        return -1;
    }
}
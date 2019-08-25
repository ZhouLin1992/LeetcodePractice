class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        
        distance[start[0]][start[1]] = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0];
                int nextY = curr[1];
                int nextDist = distance[curr[0]][curr[1]];

                while (isValid(nextX + dx[i], nextY + dy[i], maze)) {
                    nextX += dx[i];
                    nextY += dy[i];
                    nextDist++;
                }
                
                if (distance[nextX][nextY] == -1 || distance[nextX][nextY] > nextDist) {
                    distance[nextX][nextY] = nextDist;
                    queue.offer(new int[] {nextX, nextY});
                }
            }
        }
        return distance[destination[0]][destination[1]];
    }
    
    private boolean isValid(int x, int y, int[][] maze) {
        if (0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
            return true;
        }
        return false;
    }
}
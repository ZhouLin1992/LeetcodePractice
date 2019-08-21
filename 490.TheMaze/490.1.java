class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return true;
        }
        
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            
            visited[curr[0]][curr[1]] = true;
            
            for (int i = 0; i < 4; i++) {
                int nextX = curr[0];
                int nextY = curr[1];

                while (isValid(visited, nextX + dx[i], nextY + dy[i], maze)) {
                    nextX += dx[i];
                    nextY += dy[i];
                }
                
                if (!visited[nextX][nextY]) {
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        return false;
    }
    
    private boolean isValid(boolean[][] visited, int nextX, int nextY, int[][] maze) {
        if (0 <= nextX && nextX < maze.length && 0 <= nextY && nextY < maze[0].length && maze[nextX][nextY] == 0) {
            return true;
        }
        return false;
    }
}
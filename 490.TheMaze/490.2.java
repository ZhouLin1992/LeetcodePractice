class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return true;
        }
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }
    
    private boolean dfs(int[][] maze, boolean[][] visited, int[] curr, int[] destination) {
        if (visited[curr[0]][curr[1]]) {
            return false;
        }
        
        if (curr[0] == destination[0] && curr[1] == destination[1]) {
            return true;
        }
        
        visited[curr[0]][curr[1]] = true;
        
        for (int i = 0; i < 4; i++) {
            int[] next = roll(maze, curr[0], curr[1], dx[i], dy[i]);
            if (dfs(maze, visited, next, destination)) {
                return true;
            }
        }
        return false;
    }
    
    private int[] roll(int[][] maze, int row, int col, int x, int y) {
        while (isValid(maze, row + x, col + y)) {
            row += x;
            col += y;
        }
        return new int[]{row, col};
    }
    
    private boolean isValid(int[][] maze, int nextX, int nextY) {
        if (0 <= nextX && nextX < maze.length && 0 <= nextY && nextY < maze[0].length && maze[nextX][nextY] == 0) {
            return true;
        }
        return false;
    }
}
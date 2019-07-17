class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                max = Math.max(max, bfs(grid, r, c));
            }
        }
        
        return max;
    }
    
    private int bfs(int[][] grid, int r, int c) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Coordinate> queue = new LinkedList<>(); 
        
        if (grid[r][c] == 1) {
            queue.offer(new Coordinate(r, c));
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            int x = coor.x;
            int y = coor.y;

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                count++;
                grid[x][y] = 2;
                for (int i = 0; i < 4; i++) {
                    queue.offer(new Coordinate(x + dx[i], y + dy[i]));
                }
            }
        }

        return count;
    }
    
    private class Coordinate {
        int x;
        int y;
        public Coordinate(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        if (freshCount == 0) {
            return 0;
        }
        int count = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int i = 0; i < 4; i++) {
                    int x1 = x + dx[i];
                    int y1 = y + dy[i];

                    if (x1 < 0 || x1 >= row || y1 < 0 || y1 >= col || grid[x1][y1] == 2 || grid[x1][y1] == 0) {
                        continue;
                    }

                    grid[x1][y1] = 2;
                    queue.offer(new int[] {x1, y1});
                    freshCount--;
                }
            }

        }
        
        return freshCount == 0 ? count - 1 : -1;
    }
}
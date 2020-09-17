class Solution {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        Queue<int[]> pQueue = new LinkedList<>();
        boolean[][] pacific = new boolean[rows][cols];
        
        Queue<int[]> aQueue = new LinkedList<>();
        boolean[][] atlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            pQueue.add(new int[]{r, 0});
            pacific[r][0] = true;

            aQueue.add(new int[]{r, cols - 1});
            atlantic[r][cols - 1] = true;
        }
        
        for (int c = 0; c < cols; c++) {
            pQueue.add(new int[]{0, c});
            pacific[0][c] = true;

            aQueue.add(new int[]{rows - 1, c});
            atlantic[rows - 1][c] = true;
        }
        
        bfs(pQueue, pacific, matrix);
        bfs(aQueue, atlantic, matrix);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        
        return result;
    }
    
    private void bfs(Queue<int[]> queue, boolean[][] visited, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                int[] next = new int[]{x, y};
                
                if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || matrix[x][y] < matrix[curr[0]][curr[1]]) {
                    continue;
                }

                queue.offer(next);
                visited[x][y] = true;
            }
        }
    }
}
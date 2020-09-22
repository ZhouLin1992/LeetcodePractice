class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        if (image[sr][sc] == newColor) {
            return image;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int color = image[sr][sc];
        
        int rows = image.length;
        int cols = image[0].length;
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            if (image[r][c] != color) {
                continue;
            }
            image[r][c] = newColor;
            for (int i = 0; i < 4; i++) {
                int x = r + dx[i];
                int y = c + dy[i];
                if (x < 0 || x == rows || y < 0 || y == cols) {
                    continue;
                }
                queue.offer(new int[]{x, y});
            }
        }
        
        return image;
    }
}
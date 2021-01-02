class Solution {
    public int shortestPathAllKeys(String[] grid) {
        if (grid == null || grid[0] == null || grid[0].length() == 0) {
            return -1;
        }
        
        int rows = grid.length;
        int cols = grid[0].length();
        int[] start = new int[3];
        
        int keys = 0;
        for (int r = 0; r < rows; r++) {
            char[] chs = grid[r].toCharArray();
            for (int c = 0; c < cols; c++) {
                char ch = chs[c];
                if (ch == '@') {
                    start[0] = r;
                    start[1] = c;
                } else if ('a' <= ch && ch <= 'f') {
                    keys |= (1 << (ch - 'a'));
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start[0] + " " + start[1] + " " + start[2]);
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                
                for (int i = 0; i < 4; i++) {
                    int x = curr[0] + dx[i];
                    int y = curr[1] + dy[i];
                    int key = curr[2];
                    
                    if (x < 0 || x >= rows || y < 0 || y >= cols) {
                        continue;
                    }

                    char ch = grid[x].charAt(y);
                    if (ch == '#') {
                        continue;
                    }

                    if ('A' <= ch && ch <= 'F' && (key >> (ch - 'A') & 1) == 0) {
                        continue;
                    }

                    if ('a' <= ch && ch <= 'f') {
                        key |= (1 << (ch - 'a'));
                    }

                    if (key == keys) {
                        return moves + 1;
                    }
                    
                    if (visited.add(x + " " + y + " " + key)) {
                        queue.offer(new int[] {x, y, key});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
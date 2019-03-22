class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols);
        int total = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    total++;
                }
            }
        }
        
        uf.setCount(total);
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != '1') {
                    continue;
                }
                
                if (r > 0 && grid[r - 1][c] == '1') {
                    uf.connect(r * cols + c, (r - 1) * cols + c);
                }
                
                if (r < rows - 1 && grid[r + 1][c] == '1') {
                    uf.connect(r * cols + c, (r + 1) * cols + c);
                }
                
                if (c > 0 && grid[r][c - 1] == '1') {
                    uf.connect(r * cols + c, r * cols + c - 1);
                }
                
                if (c < cols - 1 && grid[r][c + 1] == '1') {
                    uf.connect(r * cols + c, r * cols + c + 1);
                }
            }
        }
        
        return uf.queryCount(); 
    }
}

class UnionFind {
    private int[] father;
    private int count;
    
    public UnionFind(int n) {
        father = new int[n];
        
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    
    public int find(int x) {
        while (father[x] != x) {
            x = father[x];
        }
        return x;
    }
    
    public void connect(int x, int y) {
        int find_x = find(x);
        int find_y = find(y);
        if (father[find_x] != find_y) {
            father[find_x] = find_y;
            count--;
        }
    }
    
    public void setCount(int total) {
        count = total;
    }
    
    public int queryCount() {
        return count;
    }
}
class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        
        int len = M.length;
        UnionFind uf = new UnionFind(len);
        uf.setCount(len);
        
        for (int r = 0; r < len; r++) {
            for (int c = r + 1; c < M[0].length; c++) {
                if (M[r][c] == 1) {
                    uf.union(r, c);
                }
            }
        }
        
        return uf.queryCount();
    }

}

class UnionFind {
    int[] father;
    int count;
    
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    public void union(int x, int y) {
        int father_x = find(x);
        int father_y = find(y);
        if (father_x != father_y) {
            father[father_x] = father_y;
            count--;
        }
    }
    
    public void setCount(int n) {
        this.count = n;
    }
    
    public int queryCount() {
        return count;
    }
}
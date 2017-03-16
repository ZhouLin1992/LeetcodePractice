public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (uf.compress_find(edges[i][0]) == uf.compress_find(edges[i][1])) {
                return false;
            }
            
            uf.union(edges[i][0], edges[i][1]);
        }
        
        return true;
    }
}

class UnionFind {
    HashMap<Integer, Integer> father;
    
    public UnionFind(int n) {
        father = new HashMap<>();
        for (int i = 0; i < n; i++) {
            father.put(i, i);
        }
    }
    
    public int compress_find(int x) {
        int parent = father.get(x);
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        
        while (x != father.get(x)) {
            int next = father.get(x);
            father.put(x, parent);
            x = next;
        }
        
        return parent;
    }
    
    public void union(int x, int y) {
        int root_x = compress_find(x);
        int root_y = compress_find(y);
        if (root_x != root_y) {
            father.put(root_x, root_y);
        }
    }
}
// https://www.youtube.com/watch?v=mKUsbABiwBI

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (connections == null || connections.size() == 0) {
            return connections;
        }
        
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }
        
        Set<List<Integer>> set = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        dfs(0, 0, set, graph, rank);
        return new ArrayList<>(set);
    }
    
    private int dfs(int node, int level, Set<List<Integer>> set, List<Integer>[] graph, int[] rank) {
        // this node was visited, return its rank
        if (rank[node] >= 0) {
            return rank[node];
        }
        
        rank[node] = level;
        int minLevelFound = level;
        
        for (int nei : graph[node]) {
            // this is parent, ignore
            if (rank[nei] == level - 1) {
                continue;
            }
            
            int minLevel = dfs(nei, level + 1, set, graph, rank);
            minLevelFound = Math.min(minLevel, minLevelFound);
            
            if (minLevel <= level) {
                set.remove(Arrays.asList(node, nei));
                set.remove(Arrays.asList(nei, node));
            }
        }
        
        return minLevelFound;
    }
}
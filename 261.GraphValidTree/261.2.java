public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // |V| - 1 = |E|
        if (n - 1 != edges.length) {
            return false;
        }
        
        // 看各个点是否联通        
        Map<Integer, List<Integer>> map = initialization(n, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int visited = 0;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i: map.get(cur)) {
                if (set.contains(i)) {
                    continue;
                }
                queue.offer(i);
                set.add(i);
            }
            visited++;
        }
        
        return visited == n;
    }
    
    private Map<Integer, List<Integer>> initialization(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        return map;
    }
}
java
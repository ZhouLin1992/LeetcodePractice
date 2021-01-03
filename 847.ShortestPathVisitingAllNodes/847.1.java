// http://zxi.mytechroad.com/blog/graph/leetcode-847-shortest-path-visiting-all-nodes/

class Solution {
    public int shortestPathLength(int[][] graph) {
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            queue.offer(new int[]{i, 1 << i});
        }
        Set<String> visited = new HashSet<>();
        
        int target = (1 << graph.length) - 1;
        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int node = curr[0];
                int state = curr[1];
                
                if (state == target) {
                    return moves;
                }
                
                if (!visited.add(node + " " + state)) {
                    continue;
                }
                
                for (int nei : graph[node]) {
                    queue.offer(new int[]{nei, state | (1 << nei)});
                }
            }
            moves++;
        }
        
        return moves;
    }
}
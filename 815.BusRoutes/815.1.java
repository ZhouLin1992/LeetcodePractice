class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0 || routes[0].length == 0 || S == T) {
            return 0;
        }
        
        int routeCount = routes.length;
        // bus stop 和 route 对应的 map
        Map<Integer, Set<Integer>> busToRoute = new HashMap<>();
        for (int i = 0; i < routeCount; i++) {
            for (int s : routes[i]) {
                busToRoute.computeIfAbsent(s, stop -> new HashSet<>()).add(i);
            }
        }
        
        int busToTake = 0;
        // 记录走过的 route
        boolean[] visitedRoute = new boolean[routeCount];
        // 记录走过的 stop
        Set<Integer> visitedStops = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        // int[]: bus stop & bus数
        queue.offer(new int[]{S, 0});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int stop = curr[0];
                int busAlreadyTake = curr[1];
                
                if (stop == T) {
                    return busAlreadyTake;
                }
                
                if (visitedStops.contains(stop)) {
                    continue;
                }
                
                for (int route : busToRoute.get(stop)) {
                    if (visitedRoute[route]) {
                        continue;
                    }
                    
                    for (int s : routes[route]) {
                        queue.offer(new int[]{s, busAlreadyTake + 1});
                    }
                    
                    visitedRoute[route] = true;
                }
            }
        }
        
        return -1;
    }
}
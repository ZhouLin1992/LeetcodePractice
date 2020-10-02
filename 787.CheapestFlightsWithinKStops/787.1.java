class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> flightMap = new HashMap<>();
        // <source, <destination, price>>
        for (int[] flight : flights) {
            flightMap.computeIfAbsent(flight[0], priceMap -> new HashMap<>()).put(flight[1], flight[2]);
        }
        // the cheapest total price come first
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // total price, current city, stops left
        queue.offer(new int[]{0, src, K + 1});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int totalPrice = curr[0];
            int currCity = curr[1];
            int stopsLeft = curr[2];
            
            if (currCity == dst) {
                return totalPrice;
            }
            
            if (stopsLeft > 0) {
                Map<Integer, Integer> adj = flightMap.get(currCity);
                if (adj != null) {
                    for (int next : adj.keySet()) {
                        queue.offer(new int[]{totalPrice + adj.get(next), next, stopsLeft - 1});
                    }
                }
            }
        }
        return -1;
    }
}
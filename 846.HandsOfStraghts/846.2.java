class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0 || hand.length < W) {
            return false;
        }
        
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int i : map.keySet()) {
            if (map.get(i) > 0) {
                for (int j = 1; j < W; j++) {
                    if (map.getOrDefault(i + j, 0) < map.get(i)) {
                        return false;
                    }
                    map.put(i + j, map.get(i + j) - map.get(i));
                }
            }
        }
        
        return true;
    }
}
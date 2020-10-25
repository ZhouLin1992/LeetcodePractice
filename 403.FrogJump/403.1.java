class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(stones[0]).add(1);
        int len = stones.length;
        
        for (int stone : stones) {
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[len - 1]) {
                    return true;
                }
                
                if (map.containsKey(reach)) {
                    Set<Integer> steps = map.get(reach);
                    steps.add(step);
                    if (step - 1 > 0) {
                        map.get(reach).add(step - 1);
                    }
                    map.get(reach).add(step + 1);    
                }
            }
        }
        
        return false;
    }
}
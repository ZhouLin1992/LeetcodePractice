class Solution {
    public int minAreaRect(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            Set<Integer> set = map.get(p[0]);
            if (set == null) {
                set = new HashSet<>();
                map.put(p[0], set);
            }
            set.add(p[1]);
        }
        
        int minArea = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    minArea = Math.min(minArea, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }
            }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}
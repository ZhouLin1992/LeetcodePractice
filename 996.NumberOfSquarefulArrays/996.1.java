class Solution {
    int count = 0;
    public int numSquarefulPerms(int[] A) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Set<Integer>> squareMap = new HashMap<>();
        
        for (int num : A) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
                squareMap.put(num, new HashSet<>());
            }
        }
        
        for (int numA : countMap.keySet()) {
            for (int numB : countMap.keySet()) {
                double c = Math.sqrt(numA + numB);
                if (c == Math.floor(c)) {
                    squareMap.get(numA).add(numB);
                    squareMap.get(numB).add(numA);
                }
            }
        }

        for (int num : countMap.keySet()) {
            permutation(countMap, squareMap, num, A.length - 1);
        }
        
        return count;
    }
    
    private void permutation(Map<Integer, Integer> countMap, Map<Integer, Set<Integer>> squareMap, int num, int pos) {
        countMap.put(num, countMap.get(num) - 1);
        if (pos == 0) {
            count++;
        } else {
            for (int pair : squareMap.get(num)) {
                if (countMap.get(pair) == 0) {
                    continue;
                }
                permutation(countMap, squareMap, pair, pos - 1);
            }
        }
        countMap.put(num, countMap.get(num) + 1);
    }
}
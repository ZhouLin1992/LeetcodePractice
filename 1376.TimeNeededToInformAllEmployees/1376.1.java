/**
Top down DFS:
dfs find out the time needed for each employees.
The time for a manager = max(manager's employees) + informTime[manager]
**/

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager == null || manager.length == 0 || informTime == null || informTime.length == 0 || manager.length != informTime.length) {
            return 0;
        }
        
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int m = manager[i];
            mapping.computeIfAbsent(m, list -> new ArrayList<>()).add(i);
        }
        
        return dfs(mapping, informTime, headID);
    }
    
    private int dfs(Map<Integer, List<Integer>> mapping, int[] informTime, int cur) {
        // 证明没有下属 传达时间为0
        if (!mapping.containsKey(cur)) {
            return 0;
        }
        
        List<Integer> subordinates = mapping.get(cur);
        int max = 0;
        // 计算该manager所有下属里用时最长的
        for (int i : subordinates) {
            max = Math.max(max, dfs(mapping, informTime, i));
        }
        return max + informTime[cur];
    }
}
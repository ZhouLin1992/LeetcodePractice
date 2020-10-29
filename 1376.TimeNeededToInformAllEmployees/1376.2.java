// Bottom up dfs

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (manager == null || manager.length == 0 || informTime == null || informTime.length == 0 || manager.length != informTime.length) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < manager.length; i++) {
            max = Math.max(max, dfs(manager, informTime, i));
        }
        
        return max;
    }
    
    private int dfs(int[] manager, int[] informTime, int i) {
        // 未被visit过
        if (manager[i] != -1) {
            // informTime此时可以理解成到这个结点为止所需要的时间
            informTime[i] += dfs(manager, informTime, manager[i]);
            // mark visited
            manager[i] = -1;
        }

        // 被visit过 直接返回值
        return informTime[i];
    }
}
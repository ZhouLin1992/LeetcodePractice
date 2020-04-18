/**
https://www.youtube.com/watch?v=u_Wc4jwrp3Q&t=1174s
https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem
time: O(n^2 * 2^n) 对于每一个状态 需要枚举它的parent 所以是n^2
space: O(n * 2^n)
**/

class Solution {
    public String shortestSuperstring(String[] A) {
        int len = A.length;
        
        // g[i][j]: the cost of appending A[j] after A[i], e.g.: g('gcta', 'ctaagt') = 3
        int[][] g = new int[len][len];
        
        // g[i][j]矩阵: 得到除去左对角线的值, 左对角线上的值为0
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                g[i][j] = calculateAppend(A[i], A[j]);
                g[j][i] = calculateAppend(A[j], A[i]);
            }
        }
        
        // dp[s][i]: min cost to visit nodes in s and ends with i; s is a binary string, e.g.: dp[14][2] is the min cost to visit {1, 2, 3} and ends with 2 (14 = 2^1 + 2^2 + 2^3)
        int[][] dp = new int[1 << len][len];
        // path[i][j]: the node before j, j is the last node
        int[][] path = new int[1 << len][len];
        // global min path
        int min = Integer.MAX_VALUE;
        // global last ending node
        int last = -1;
        
        // 状态转移方程：dp[i][j] = min{dp[i - 2^j][k] + g[k][j]} 枚举所有的parent, append A[i] after A[j]
        for (int i = 1; i < (1 << len); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < len; j++) {
                // j is not in the node set
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                
                int prev = i - (1 << j);
                // if j is the only node
                if (prev == 0) {
                    // min cost is the whole word length
                    dp[i][j] = A[j].length();
                } else {
                    for (int k = 0; k < len; k++) {
                        if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + g[k][j] < dp[i][j]) {
                            dp[i][j] = dp[prev][k] + g[k][j];
                            // update the node before j
                            path[i][j] = k;
                        }
                    }
                }
                
                // update 全局最小值
                if (i == (1 << len) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    // update ending node
                    last = j;
                }
            }
        }
        
        // build the path
        Deque<Integer> stack = new LinkedList<>();
        int curr = (1 << len) - 1;
        while (curr > 0) {
            stack.push(last);
            int temp = curr;
            curr -= (1 << last);
            last = path[temp][last];
        }
        
        StringBuilder sb = new StringBuilder();
        int i = stack.pop();
        sb.append(A[i]);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            sb.append(A[j].substring(A[j].length() - g[i][j]));
            i = j;
        }
        
        return sb.toString();
    }
    
    private int calculateAppend(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        
        return b.length();
    }
}
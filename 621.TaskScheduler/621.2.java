class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0 || n < 0) {
            return 0;
        }
        
        int[] counts = new int[26];

        for (char ch : tasks) {
            counts[ch - 'A']++;            
        }
        Arrays.sort(counts);

        // get the number of tasks have the same max count        
        int i = 25;
        while (i > 0 && counts[i] == counts[25]) {
            i--;
        }

        return Math.max(tasks.length, (counts[25] - 1) * (n + 1) + (25 - i));
    }
}
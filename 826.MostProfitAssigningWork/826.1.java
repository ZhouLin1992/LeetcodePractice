class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        if (difficulty == null || difficulty.length == 0 || profit == null || profit.length == 0 || worker == null || worker.length == 0) {
            return 0;
        }
        
        int len = profit.length;
        List<Job> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Job(difficulty[i], profit[i]));
        }
        Collections.sort(list, (j1, j2) -> (j1.diff - j2.diff));
        Arrays.sort(worker);
        
        int result = 0;
        
        int i = 0;
        int best = 0;
        for (int w : worker) {
            while (i < len && w >= list.get(i).diff) {
                best = Math.max(best, list.get(i).profit);
                i++;
            }
            result += best;
        }
        
        return result;
    }
}

class Job {
    int diff;
    int profit;
    public Job(int _diff, int _profit) {
        diff = _diff;
        profit = _profit;
    }
}
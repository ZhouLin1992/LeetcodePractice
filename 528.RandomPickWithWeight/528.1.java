class Solution {
    int[] probability;
    int sum;
    Random random;
    
    public Solution(int[] w) {
        probability = new int[w.length];
        probability[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            probability[i] = probability[i - 1] + w[i];
        }
        sum = probability[w.length - 1];
        random = new Random();
    }
    
    public int pickIndex() {
        int target = random.nextInt(sum) + 1;
        return bs(target);
    }
    
    private int bs(int target) {
        int start = 0;
        int end = probability.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (probability[mid] == target) {
                return mid;
            } else if (probability[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (probability[start] >= target) {
            return start;
        }
        if (probability[end] >= target) {
            return end;
        }
        return end + 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
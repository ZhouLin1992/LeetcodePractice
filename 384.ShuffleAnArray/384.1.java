public class Solution {
    private int[] nums;
    private int[] shuffleNums;
    private Random rand;
    
    public Solution(int[] nums) {
        this.nums = nums;    
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        shuffleNums = Arrays.copyOf(nums, nums.length);
        for (int i = nums.length - 1; i >= 1; i--)
            swap(i, rand.nextInt(i + 1), shuffleNums);
        return shuffleNums;
    } 
    
    private void swap(int i, int j, int[] shuffle) {
        if (i == j || (shuffle[i] ^ shuffle[j]) == 0) return;
        shuffle[i] ^= shuffle[j];
        shuffle[j] ^= shuffle[i];
        shuffle[i] ^= shuffle[j];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
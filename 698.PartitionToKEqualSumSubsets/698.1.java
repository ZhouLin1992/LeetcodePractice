class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % k != 0) {
            return false;
        }
        sum /= k;
        
        boolean[] visited = new boolean[nums.length];
        
        return canPartitionKSubsets(nums, visited, sum, k, 0, 0);
    }
    
    private boolean canPartitionKSubsets(int[] nums, boolean[] visited, int target, int k, int currSum, int start) {
        if (k == 0) {
            return true;
        }
        
        if (currSum > target) {
            return false;
        }
        
        if (currSum == target) {
            return canPartitionKSubsets(nums, visited, target, k - 1, 0, 0);
        }
        
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartitionKSubsets(nums, visited, target, k, currSum + nums[i], i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        
        return false;
    }
}
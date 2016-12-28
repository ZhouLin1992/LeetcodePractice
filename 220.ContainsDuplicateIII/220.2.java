// Using Bucket
// O(N) time, O(k) space

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums ==  null || nums.length == 0 || k < 1 || t < 0) {
            return false;
        }
        
        Map<Long, Long> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            long reMappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = reMappedNum / ((long)t + 1);
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && map.get(bucket - 1) >= reMappedNum - t) ||
                (map.containsKey(bucket + 1) && map.get(bucket + 1) <= reMappedNum + t)) {
                return true;
            }
                
            if (map.keySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            
            map.put(bucket, reMappedNum);
        }
        
        return false;
    }
}
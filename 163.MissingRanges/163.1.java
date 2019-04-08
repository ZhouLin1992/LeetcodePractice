class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        // the next number we need to find
        long next = lower;
        
        for (int i = 0; i < nums.length; i++) {
            // not within the range yet
            if (nums[i] < next) {
                continue;
            }
            
            // continue to find the next one
            if (nums[i] == next) {
                next++;
                continue;
            }
            
            result.add(getRange(next, nums[i] - 1));
            
            // handle overflow
            next = (long) nums[i] + 1;
        }
        
        // do a final check
        if (next <= upper) {
            result.add(getRange(next, upper));
        }
        
        return result;
    }
    
    private String getRange(long start, long end) {
        return start == end ? String.valueOf(start) : String.format("%d->%d", start, end);
    }
}
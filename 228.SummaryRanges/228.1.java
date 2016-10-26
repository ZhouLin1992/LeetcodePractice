public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                res.add(generate(start, end));
                start = nums[i]; 
            }
            end = nums[i];
        }
        res.add(generate(start, end));
        return res;
    }
    
    public String generate(int start, int end) {
        if (start == end)
            return "" + start;
        else 
            return start + "->" + end;
    }
}
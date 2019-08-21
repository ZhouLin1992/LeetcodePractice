class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        int slow = 0;
        int fast = 0;
        int len = s.length();
        int[] counts = new int[256];
        int result = Integer.MIN_VALUE;
        
        while (fast < len) {
            if (counts[s.charAt(fast)]++ == 0) {
                count++;
            }
            if (count > k) {
                do {
                    counts[s.charAt(slow)]--;
                } while (counts[s.charAt(slow++)] > 0);
                count--;
            }

            result = Math.max(fast - slow + 1, result);
            fast++;
        }
        
        return result;
    }
}
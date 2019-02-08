// Binary Search Solution: Time complexity = O(lg(x)) = O(32)=O(1)

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int start = 1;
        int end = x;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            // Look for the critical point: i * i <= x && (i+1)(i+1) > x
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid < x / mid) {
                start = mid +1; // Keep tracking the right part
            } else {
                end = mid - 1; // Keep tracking the left part
            }
        }
        
        return start;
    }
}

class Solution {
    public int reverse(int x) {
        int result = 0;
        int tail;
        
        while (x != 0) {
            tail = x % 10;
            
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && tail > 7) {
                return 0;
            }
            
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && tail < -8) {
                return 0;
            }
            
            x /= 10;
            result = result * 10 + tail;
        }
        
        return result;
    }
}
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (fast != slow);
        
        return slow == 1;
    }
    
    private int digitSquareSum(int n) {
        int sum = 0;
        int digit;
        
        while (n != 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        
        return sum;
    }
}
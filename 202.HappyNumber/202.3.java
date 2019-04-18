class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int sum = 0;
        
        while (n != 1 && visited.add(n)) {
            sum = 0;
            
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            
            n = sum;
        }
        
        return n == 1;
    }
}
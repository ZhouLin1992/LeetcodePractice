class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        
        if (x == z || y == z || x + y == z) {
            return true;
        }
        
        return z % canMeasureWaterHelper(x, y) == 0;
    }
    
    // 得到最大公约数
    private int canMeasureWaterHelper(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        
        return x;
    }
}
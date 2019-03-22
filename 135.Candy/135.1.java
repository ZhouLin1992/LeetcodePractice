class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        
        int sum = 0;
        for (int i = ratings.length - 1; i >= 1; i--) {
            sum += candy[i];
            if (ratings[i - 1] > ratings[i] && candy[i - 1] <= candy[i]) {
                candy[i - 1] = candy[i] + 1;
            }
        }
        sum += candy[0];
        
        return sum;
    }
}
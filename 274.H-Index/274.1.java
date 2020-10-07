class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int len = citations.length;
        int[] counts = new int[len + 1];
        
        for (int c : citations) {
            if (c > len) {
                counts[len]++;
            } else {
                counts[c]++;
            }
        }
        
        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += counts[i];
            if (sum >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
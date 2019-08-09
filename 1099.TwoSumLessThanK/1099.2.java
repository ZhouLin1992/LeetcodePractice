class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int result = -1;
        TreeSet<Integer> set = new TreeSet<>();
        for (int ele: A) {
            Integer diff = set.lower(K - ele);
            if (diff != null) {
                result = Math.max(result, diff + ele);
            }
            set.add(ele);
        }
        
        return result;
    }
}
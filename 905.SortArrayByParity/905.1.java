class Solution {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            while (A[left] % 2 == 1 && left < right) {
                swap(A, left, right--);
            }
            left++;
        }
        
        return A;
    }
    
    private void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
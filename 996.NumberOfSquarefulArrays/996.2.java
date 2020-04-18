class Solution {
    private int count = 0;
    
    public int numSquarefulPerms(int[] A) {
        Arrays.sort(A);
        permutation(A, new boolean[A.length], -1, new LinkedList<>());
        return count;
    }
    
    private void permutation(int[] A, boolean[] used, int last, List<Integer> curr) {
        if (curr.size() == A.length) {
            count++;
            return;
        }
        
        for (int i = 0; i < A.length; i++) {
            if (used[i]) {
                continue;
            }
            
            // 需要判定used[i - 1] 来解决duplicates
            if (i > 0 && A[i] == A[i - 1] && !used[i - 1]) {
                continue; 
            }
            
            if (last == -1 || isSquare(last, A[i])) {
                used[i] = true;
                curr.add(A[i]);
                permutation(A, used, A[i], curr);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
    
    private boolean isSquare(int a, int b) {
        int sum = a + b;
        int tmp = (int) Math.sqrt(sum);
        return tmp * tmp == sum;
    }
}
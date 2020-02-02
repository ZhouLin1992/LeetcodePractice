// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/discuss/465585/JavaC%2B%2BPython-Find-the-Rule

class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = 2 * i - n + 1;
        }
        return A;
    }
}
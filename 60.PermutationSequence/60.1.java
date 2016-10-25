public class Solution {
    public String getPermutation(int n, int k) {
		List<Integer> nums = new LinkedList<>();
		for (int i = 1; i <= n; i++) 
			nums.add(i);
		int[] factorial = new int[n];
		factorial[0] = 1;
		for (int i = 1; i < n; i++) 
			factorial[i] = factorial[i - 1] * i;
		StringBuilder sb = new StringBuilder();
		k--;
		for (int i = n; i >= 1; i--) {
			int idx = k / factorial[i - 1];
			sb.append(nums.get(idx));
			k %= factorial[i - 1];
			nums.remove(idx);
		}
		return sb.toString();
    }
}
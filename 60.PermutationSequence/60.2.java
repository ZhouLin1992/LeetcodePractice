public class Solution {
    public String getPermutation(int n, int k) {
		List<Integer> nums = new ArrayList<>();
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			nums.add(i);
			fact *= i;
		}

		StringBuilder sb = new StringBuilder();
		for (k--; n > 0; n--) {
			fact /= n;
			int idx = k / fact;
			sb.append(nums.get(idx));
			nums.remove(idx);
			k %= fact;
		}
		return sb.toString();
    }
}
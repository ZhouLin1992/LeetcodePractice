public class Solution {
    public String getPermutation(int n, int k) {
		List<Integer> nums = new LinkedList<>();

		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			nums.add(i);
			if (i == n)
				break;
			factorial *= i;
		}

		StringBuilder sb = new StringBuilder();
		for (k--; n > 0; n--) {
			sb.append(nums.remove(k / factorial));
			k %= factorial;
			if (nums.size() == 0)
			    break;
			factorial /= nums.size();
		}
		return sb.toString();
    }
}
/* https://www.jianshu.com/p/6ba754de4f68
遍历完整个数组，以每一个数组元素结尾的subarray乘积都算过一次了，更新出来的result就是要求的解。
*/


class Solution {
    public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int len = nums.length;
		int[] min = new int[len];
		int[] max = new int[len];
		int result = nums[0];

		// ending at index i, the minimun subarray product
		min[0] = nums[0];
		// ending at index i, the maximum subarray product
		max[0] = nums[0];

		for (int i = 1; i < len; i++) {
			min[i] = nums[i];
			max[i] = nums[i];

			if (nums[i] > 0) {
				min[i] = Math.min(min[i], min[i - 1] * nums[i]);
				max[i] = Math.max(max[i], max[i - 1] * nums[i]);
			} else {
				min[i] = Math.min(min[i], max[i - 1] * nums[i]);
				max[i] = Math.max(max[i], min[i - 1] * nums[i]);
			}

			if (result < max[i]) {
				result = max[i];
			}
		}

		return result;
    }
}
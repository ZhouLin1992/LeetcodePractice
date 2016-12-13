// similar to LinkedList Cycle II
// 由于题目限定了区间[1,n]，所以可以巧妙的利用坐标和数值之间相互转换，而由于重复数字的存在，那么一定会形成环
// Time: O(N)
// Space: O(1)

public class Solution {
	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		int find = 0;

		do {
			slow = nums[slow];
			find = nums[find];
		} while (slow != find);

		return find;
	}
}
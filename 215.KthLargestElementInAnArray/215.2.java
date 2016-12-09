// Time: O(NlogN)
// Space: O(1)
// Sort the array first, and access the element at index(len - k)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
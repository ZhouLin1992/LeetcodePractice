// data sturcture: TreeSet
// time complexity: O(Nlogk), k is the size of the TreeSet
// space complexity: O(k)

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums ==  null || nums.length == 0 || k < 1 || t < 0) {
            return false;
        }
        
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // <=的given最大元素, O(logN)
            Integer floor = set.floor(nums[i] + t);
            // >=的given最小元素, O(logN)
            Integer ceiling = set.ceiling(nums[i] - t);
            
            if (floor != null && floor >= nums[i] || ceiling != null && ceiling <= nums[i]) {
                return true;
            }
            
            // add the number into the set, O(logN)
            set.add(nums[i]);
            // the number of elements is more than k
            if (i >= k) {
                // delete elements appearing before, O(logN)
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;
        for (int p1 = 0; p1 < nums.length - 2; p1++) {
            if (p1 == 0 || p1 > 0 && nums[p1] != nums[p1 - 1]) {
                for (int p2 = p1 + 1; p2 < nums.length - 1; p2++) {
                    if (p2 == p1 + 1 || p2 > p1 + 1 && nums[p2] != nums[p2 - 1]) {
                        int tmp = 0 - nums[p1] - nums[p2];
                        int p3 = p2 + 1;
                        while (p3 < nums.length && nums[p3] < tmp)
                            p3++;
                        if (p3 < nums.length && nums[p3] == tmp)
                            res.add(Arrays.asList(nums[p1], nums[p2], nums[p3]));
                    }
                }     
            }
        }
        return res;
    }
}
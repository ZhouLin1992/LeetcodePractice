class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<>();
        
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int count1 = 0;
        int count2 = 0;
        int candidate1 = nums[0];
        int candidate2 = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
                continue;
            }
            
            if (candidate2 == nums[i]) {
                count2++;
                continue;
            }
            
            if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
                continue;
            }
            
            if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
                continue;
            }
            
            count1--;
            count2--;
        }
        
        int c1 = 0;
        int c2 = 0;
        
        for (int num : nums) {
            if (candidate1 == num) {
                c1++;
            } else if (candidate2 == num) {
                c2++;
            }
        }
        
        if (c1 > nums.length / 3) {
            result.add(candidate1);
        }
        
        if (c2 > nums.length / 3) {
            result.add(candidate2);
        }
        
        return result;
    }
}
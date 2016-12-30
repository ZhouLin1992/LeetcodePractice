public class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	// 不能使用数组前两个数来初始化n1/n2，因为数组前两个数可能是相同的
        int n1 = 0, n2 = 1, c1 = 0, c2 = 0;
        // 判断顺序很重要，不能先判断count
        // 如果先判断count,则有可能出现两个相同candidate的情况
        for (int num: nums) {
            if (num == n1) {
                c1++;
            } else if (num == n2) {
                c2++;
            } else if (c1 == 0) {
                n1 = num;
                c1++;
            } else if (c2 == 0) {
                n2 = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        List<Integer> list = new ArrayList<>();
        for (int num: nums) {
            if (num == n1) {
                c1++;
            }
            if (num == n2) {
                c2++;
            }
        }
        
        if (c1 > nums.length / 3) {
            list.add(n1);
        }
        if (c2 > nums.length / 3) {
            list.add(n2);
        }
        
        return list;
    }
}
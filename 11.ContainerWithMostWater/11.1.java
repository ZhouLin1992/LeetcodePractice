/*
    设置两个指针i, j, 一头一尾, 相向而行. 假设i指向的挡板较低, j指向的挡板较高(height[i] < height[j]).
    下一步移动哪个指针?
    -- 若移动j, 无论height[j-1]是何种高度, 形成的面积都小于之前的面积.
    -- 若移动i, 若height[i+1] <= height[i], 面积一定缩小; 但若height[i+1] > height[i], 面积则有可能增大.
    综上, 应该移动指向较低挡板的那个指针.
*/

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            max = Math.max((right - left) * Math.min(height[left], height[right]), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
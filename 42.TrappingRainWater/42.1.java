/*
这道题的思路是采用l和r两个指针，维护装水两边的位置。

首先找到有效的两边，如 [0, 1, 2, 3, 0, 3, 2, 1, 0]，递增的左边和递减的右边是不能盛水的。

当l处高度低时，说明l右侧装的水肯定和l处一样高(蓄水水平线不会比l更高，l是瓶颈)，此时逐步右移l，
同时加上l处与右移后位置高度差（因为这里都能装水啊），直到再遇到同样高或者更高的位置。然后进行下一轮判断。

同样，当r处高度低时，说明r左侧的水肯定和r处一样高，此时逐步左移r，同是加上r处与左移后位置高度差，
直到再遇到同样高或者更高的位置。

最后直到l和r相遇，结束。
*/

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        // find the left edge which can hold water
        while(left < right && height[left] <= height[left + 1]) {
            left++;
        }
        // find the right edge which can hold water
        while(left < right && height[right] <= height[right - 1]) {
            right--;
        }
        
        int leftHeight = height[left], rightHeight = height[right];
        int res = 0;
        while(left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (leftHeight > height[left]) {
                    res += leftHeight - height[left];
                } else {
                    leftHeight = height[left];
                }
            } else {
                right--;
                if (rightHeight > height[right]) {
                    res += rightHeight - height[right];
                } else {
                    rightHeight = height[right];
                }
            }
        }
        
        return res;
    }
}
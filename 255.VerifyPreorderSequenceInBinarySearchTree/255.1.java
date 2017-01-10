// Space & Time complexity: O(N)

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        for (int num: preorder) {
            // 违反了最小值限定
            if (num < low) {
                return false;
            }
            // 找到所有小于当前数的值，pop出来，同时更新low值
            while (!stack.isEmpty() && num > stack.peek()) {
                low = stack.pop();
            }
            // 将当前值push进stack
            stack.push(num);
        }
        return true;
    }
}
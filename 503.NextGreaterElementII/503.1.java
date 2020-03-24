class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] next = new int[2 * len];
        Arrays.fill(next, -1);
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                next[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return Arrays.copyOfRange(next, 0, len);
    }
}
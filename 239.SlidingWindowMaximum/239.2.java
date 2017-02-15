/*
队列中存的是那个数在原数组中的下标，这样我们既可以直到这个数的值，
也可以知道该数是不是窗口最左边的数。
*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            // 每当新数进来时，如果发现队列头部的数的下标，是窗口最左边数的下标，则扔掉
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if (i + 1 >= k) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return res;
    }
}
/*
1.维护一个递减的Deque（单调双端队列）
2.当我们遇到新的数时，将新的数和双向队列的末尾比较:如果末尾比新数小，
则把末尾扔掉，直到该队列的末尾比新数大或者队列为空的时候才住手。这样，
我们可以保证队列里的元素是从头到尾降序的。由于队列里只有窗口内的数，
所以他们其实就是窗口内第一大，第二大，第三大...的数。
3.保持队列里只有窗口内数的方法：每来一个新的把窗口最左边的扔掉，然后把新的加进去。
4.为什么要用Deque?
当前为[9, 8, 7], 6进入，6 < 7, 6进入
[9, 8, 7, 6] 但是对K=3的窗口，必须要弹出9，这步就要用到deque


时间：O(N)
每个数只可能被操作最多两次，一次是加入队列的时候；一次是因为有别的更大数在后面，所以被扔掉，
或者因为出了窗口而被扔掉。

空间：O(k)，维护一个O(k)大的Deque
*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        
        int len = nums.length;
        // the result length is len - (k - 1)
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < k - 1; i++) {
            inDeque(deque, nums[i]);
        }
        
        for (int i = k - 1; i < len; i++) {
            inDeque(deque, nums[i]);
            res[i - k + 1] = deque.peek();
            outDeque(deque, nums[i - k + 1]);
        }
        
        return res;
    }
    
    private void inDeque(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }
    
    private void outDeque(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.poll();
        }
    }
}
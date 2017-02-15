// 时间：O((logk + k)N)
// 空间：O(k)

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        
        // 数组的大小是nums.length - k + 1,
        // 赋值时下标也是i + 1 - k
        int[] res = new int[nums.length - k + 1];
        // max heap
        Queue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            // 把窗口最左边的数去掉
            if (i >= k) {
                pq.remove(nums[i - k]);
            }
            // 把新的数加入窗口的堆中
            pq.offer(nums[i]);
            // 堆顶就是窗口的最大值
            if (i + 1>= k) {
                res[i - k + 1] = pq.peek();
            }
        }
        
        return res;
    }
}
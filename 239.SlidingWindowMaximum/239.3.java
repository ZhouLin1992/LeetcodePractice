/*
大概思路是用双向队列保存数字的下标，遍历整个数组.
如果此时队列的首元素是i - k的话，表示此时窗口向右移了一步，则移除队首元素。
然后比较队尾元素和将要进来的值，如果小的话就都移除，然后此时我们把队首元素加入结果中即可.

时间：O((logk + k)N)
空间：O(k)
*/
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
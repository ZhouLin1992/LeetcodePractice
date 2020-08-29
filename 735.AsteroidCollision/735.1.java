// 最后的状态是 负数集中在左边 正数集中在右边

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return asteroids;
        }
        
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            // 如果是正数 | stack为空 | stack顶部的数负数，加入stack
            if (asteroids[i] > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroids[i]);
            // 如果stack顶部的正数 <= asteroids[i]的绝对值
            } else if (stack.peek() <= -asteroids[i]) {
                // 如果stack顶部的正数 < asteroids[i]的绝对值，表明stack顶部的数要被去掉，继续停留在i这个位置与stack剩下的数进行比较
                if (stack.pop() < -asteroids[i]) {
                    i--;
                }
                // 如果两数相等，则stack顶部的数被去掉，继续比较asteroids里的下一个值
            }
            // 如果stack顶部的数 > asteroids[i]，i位置的数不加入stack
        }
        
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
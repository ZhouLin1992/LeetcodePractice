class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        // min heap
        Queue<Integer> poHeap = new PriorityQueue<>();
        // max heap
        Queue<Integer> neHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            poHeap.offer(num);
            neHeap.offer(num);
            
            if (poHeap.size() > 3) {
                poHeap.poll();
            }
            
            if (neHeap.size() > 2) {
                neHeap.poll();
            }
        }
        
        int poMax = 1;
        int max = 0;
        
        while (!poHeap.isEmpty()) {
            max = poHeap.poll();
            poMax *= max;
        }
        
        int neMax = max;
        while (!neHeap.isEmpty()) {
            neMax *= neHeap.poll();
        }
        
        return poMax > neMax ? poMax : neMax;
    }
}
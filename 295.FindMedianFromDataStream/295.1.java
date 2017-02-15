/*
维护大顶堆（maxHeap） + 小顶堆（minHeap）

需要满足下面的约束条件：

1.大顶堆(maxHeap)中存储的元素均不大于小顶堆(minHeap)中的元素
2.MaxHeap.size() == MinHeap.size()，或者 MaxHeap.size() == MinHeap.size() + 1
3.当MaxHeap.size() == MinHeap.size() + 1时，中位数就是MaxHeap的堆顶元素
4.当MaxHeap.size() == MinHeap.size()时，中位数就是MaxHeap堆顶元素与MinHeap堆顶元素的均值
*/

public class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> minHeap, maxHeap;
    
    public MedianFinder() {
        // min heap
        minHeap = new PriorityQueue<>();
        // max heap
        maxHeap = new PriorityQueue<>(1000, Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
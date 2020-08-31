/**
hashset 的作用是标记被 pop 和 popMax 的那些数
用 heap 的作用是为了快速找到大的数
用 stack 的作用是为了找到位置上最大的数

因为每个数只进入 stack 和 heap 各一次。所以平均下来，时间复杂度是：
push:o(logN)
pop: o(1)
top: o(1)
popMax: o(logN)
peekMax: o(1)
**/

class MaxStack {
    /** initialize your data structure here. */
    private Deque<Item> stack;
    private Queue<Item> maxHeap;
    private Set<Item> poppedSet;
    private int index = 0;
    
    public MaxStack() {
        stack = new LinkedList<>();
        maxHeap = new PriorityQueue<>();
        poppedSet = new HashSet<>();
    }
    
    public void push(int x) {
        clearPoppedInStack();
        Item item = new Item(x, index);
        stack.push(item);
        maxHeap.offer(item);
        index++;
    }
    
    private void clearPoppedInStack() {
        while (!stack.isEmpty() && poppedSet.contains(stack.peek())) {
            poppedSet.remove(stack.peek());
            stack.pop();
        }
    }
    
    private void clearPoppedInHeap() {
        while (!maxHeap.isEmpty() && poppedSet.contains(maxHeap.peek())) {
            poppedSet.remove(maxHeap.peek());
            maxHeap.poll();
        }
    }
    
    public int pop() {
        clearPoppedInStack();
        Item popped = stack.pop();
        poppedSet.add(popped);
        return popped.val;
    }
    
    public int top() {
        clearPoppedInStack();
        return stack.peek().val;
    }
    
    public int peekMax() {
        clearPoppedInHeap();
        return maxHeap.peek().val;
    }
    
    public int popMax() {
        clearPoppedInHeap();
        Item item = maxHeap.poll();
        poppedSet.add(item);
        return item.val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */

class Item implements Comparable<Item> {
    public int val;
    public int location;

    public Item(int val, int location) {
        this.val = val;
        this.location = location;
    }

    public int compareTo(Item another) {
        if (this.val != another.val) {
            return another.val - this.val;
        }
        return another.location - this.location;
    }
}
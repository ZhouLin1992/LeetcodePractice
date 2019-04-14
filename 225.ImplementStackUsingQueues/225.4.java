// o(1) push, o(N) pop

class MyStack {
    Queue<Integer> queue1, queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else {
            queue2.offer(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size;
        if (queue1.isEmpty()) {
            size = queue2.size();
            for (int i = 1; i < size; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        } else {
            size = queue1.size();
            for (int i = 1; i < size; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        int size;
        int top;
        if (queue1.isEmpty()) {
            size = queue2.size();
            for (int i = 1; i < size; i++) {
                queue1.offer(queue2.poll());
            }
            top = queue2.poll();
            queue1.offer(top);
        } else {
            size = queue1.size();
            for (int i = 1; i < size; i++) {
                queue2.offer(queue1.poll());
            }
            top = queue1.poll();
            queue2.offer(top);
        }
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
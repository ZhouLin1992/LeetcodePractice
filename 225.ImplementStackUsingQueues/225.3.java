// o(N) push, o(1) pop

class MyStack {
    Queue<Integer> queue1, queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue1.offer(x);
            for (int i = 0; i < queue2.size(); i++) {
                queue1.offer(queue2.poll());
            }
        } else {
            queue2.offer(x);
            for (int i = 0; i < queue1.size(); i++) {
                queue2.offer(queue1.poll());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue1.isEmpty()) {
            return queue1.poll();
        } else {
            return queue2.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        return !queue1.isEmpty() ? queue1.peek() : queue2.peek();
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
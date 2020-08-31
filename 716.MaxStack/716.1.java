class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;
    
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }
    
    public void push(int x) {
        pushHelper(x);
    }
    
    private void pushHelper(int x) {
        int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
        
        if (x > tempMax) {
            tempMax = x;
        }
        
        stack.push(x);
        maxStack.push(tempMax);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Deque<Integer> temp = new LinkedList<>();
        
        while (stack.peek() < max) {
            temp.push(stack.pop());
            maxStack.pop();
        }
        
        stack.pop();
        maxStack.pop();
        
        while (!temp.isEmpty()) {
            pushHelper(temp.pop());
        }
        
        return max;
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
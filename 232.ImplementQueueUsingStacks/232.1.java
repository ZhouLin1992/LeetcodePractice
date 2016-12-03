// Time complexity: the loop in the peek()/pop() moves elements from input
// stack to output stack; Each element is moved once, and 
// only after pushing it, so the average time for each operation
// is O(1)

class MyQueue {
    // input stack is for pushing elements
    private Stack<Integer> input = new Stack<>();
    // output stack is for poping elements
    private Stack<Integer> output = new Stack<>();
    
    // Push element x to the back of the queue
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue
    public void pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        output.pop();
    }

    // Get the front element
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // Return whether the queue is empty
    public boolean empty() {
        if (!input.isEmpty() || !output.isEmpty()) {
            return false;
        }
        return true;
    }
}   
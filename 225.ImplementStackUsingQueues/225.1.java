// One queue
// Steps:
// 1. push new element into the queue (right now the new element is at the tail)
// 2. rotate the queue util the new element is at the head
// 3. every time push a new element, do the push() operation again

class MyStack {
    // Push element x onto stack.
	private Queue<Integer> queue = new LinkedList<>();
    
    // push operation costs too much
    public void push(int x) {
        queue.offer(x);
        for (int i = 1; i < queue.size(); i++) {
        	queue.offer(queue.poll());
        }
    }
    
    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
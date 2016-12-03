class MyStack {
	private Queue<Integer> input = new LinkedList<>();
	private Queue<Integer> output = new LinkedList<>();

	private void switchQueue() {
		Queue<Integer> tmp = input;
		input = output;
		output = tmp;
	}

	private void moveElements() {
		while (input.size() != 1) {
			output.offer(input.poll());
		}
	}

	public void push(int x) {
		input.offer(x);
	}

	public void pop() {
		moveElements();
		input.poll();
		switchQueue();
	}

	public int top() {
		moveElements();
		int tail = input.poll();
		switchQueue();
		input.offer(tail);
		return tail;
	}

	public boolean empty() {
		return input.isEmpty();
	}
}
class Solution {
    public int calculate(String s) {
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			queue.offer(ch);
		}
		queue.offer('+');
		return calculate(queue);
    }

    private int calculate(Queue<Character> infix) {
    	Deque<Integer> stack = new LinkedList<>();
    	int num = 0;
    	char sign = '+';

    	while (!infix.isEmpty()) {
    		char ch = infix.poll();

    		if (ch == ' ' || ch == '\t') {
    			continue;
    		}

    		if (Character.isDigit(ch)) {
    			num = 10 * num + (ch - '0');
    		} else if (ch == '(') {
    			num = calculate(infix);
    		} else {
    			if (sign == '+') {
    				stack.push(num);
    			} else if (sign == '-') {
    				stack.push(-num);
    			} else if (sign == '*') {
    				stack.push(stack.pop() * num);
    			} else if (sign == '/') {
    				stack.push(stack.pop() / num);
    			} 

    			num = 0;
    			sign = ch;

    			if (ch == ')') {
    				break;
    			}
    		}
    	}

    	int result = 0;
    	while (!stack.isEmpty()) {
    		result += stack.pop();
    	}

    	return result;
    }
}
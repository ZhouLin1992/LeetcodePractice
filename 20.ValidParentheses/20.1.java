public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else {
				if (stack.empty()) return false;
				else {
					switch(s.charAt(i)) {
					case ')': if (stack.pop() != '(') return false; break;
					case ']': if (stack.pop() != '[') return false; break;
					case '}': if (stack.pop() != '{') return false; break;
					}
				}
			}
		}
		return stack.empty();
	}
}
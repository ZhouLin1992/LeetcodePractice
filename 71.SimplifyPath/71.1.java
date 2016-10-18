public class Solution {
	public String simplifyPath(String path) {
		Deque<String> stack = new LinkedList<>();
		Set<String> skip = new HashSet<>(Arrays.asList(".", "..", ""));
		for (String str: path.split("/")) {
			if (str.equals("..") && !stack.isEmpty())
				stack.pop();
			else if (!skip.contains(str))
				stack.push(str);
		}
		// use StringBuilder to replace String
		// String res = "";
		// for (String dir: stack) 
		// 	res = "/" + dir + res;
		// return res.isEmpty() ? "/" : res;

		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty())
			res.append("/" + stack.pollLast());
		return res.length() == 0 ? "/" : res.toString();
	}
}
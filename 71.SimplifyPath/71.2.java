public class Solution {
    public String simplifyPath(String path) {
    	if (path == null || path.length() == 0) return "";
    	String[] strs = path.split("/");
    	Deque<String> stack = new LinkedList<>();
    	for (String str: strs) {
    		if (str.equals("..")) {
    			if (!str.isEmpty())
    				stack.pollLast();
    		}		
    		else if (str.equals("") || str.equals(".") || str.equals(".."))
    			continue;
    		else
    			stack.addLast(str);
    	}
    
    	if (stack.isEmpty()) return "" + "/";
    	StringBuilder res = new StringBuilder();
    	while (!stack.isEmpty())
    		res.append("/").append(stack.poll());
    	return res.toString();
    }
}
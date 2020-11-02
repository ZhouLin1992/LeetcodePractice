class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        
        for (String op : ops) {
            if (op.equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                int sum = first + second;
                stack.push(first);
                stack.push(sum);
                res += sum;
            } else if (op.equals("D")) {
                int temp = stack.peek() * 2;
                stack.push(temp);
                res += temp;
            } else if (op.equals("C")) {
                res -= stack.pop();
            } else {
                int num = Integer.parseInt(op);
                stack.push(num);
                res += num;
            }
        }
        
        return res;
    }
}
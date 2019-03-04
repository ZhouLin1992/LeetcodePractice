/*
Take [6, 7, 5, 2, 4, 5, 9, 3] for example

time: o(n)
space: o(n), worse case

Also, refer to the solution 5 on Leetcode
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
        	return 0;
        }

        if (heights.length == 1) {
        	return heights[0];
        }

        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
        	while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
        		maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
        	}
        	stack.push(i);
        }

        while (stack.peek() != -1) {
        	maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }

        return maxArea;
    }
}
/*
Divide and conquer
time: average o(n*log(n)), worse case o(n^2) if number in the arrays are sorted descendingly
space: o(n) in worse case recursion with depth n
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea(heights, 0, heights.length - 1);
    }
    
    private int largestRectangleArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        
        int index = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[index]) {
                index = i;
            }
        }
        
        return Math.max(Math.max(largestRectangleArea(heights, start, index - 1), largestRectangleArea(heights, index + 1, end)), 
            heights[index] * (end - start + 1));
    }
}
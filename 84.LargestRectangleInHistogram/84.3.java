// time: O(N), using increasing stack
// stack is to store index of elements in increasing order
// analysis:
// 1. for every bar, we need to find out in the left/right part,
// the first bar that is smaller than this bar, defind as "ln", "rn";
// 2. we traverse elements from left to right, and keep pushing 
// index of elements that is in the incresaing order
// 3. if the element is smaller than the top(stack.peek()) element of the stack,
// than elements before this element needs to be pop out from the stack until
// the stack is in the increasing order again
// 4. we need to find out the left/right bound of a bar: description is in
// the annotation of the code below
// corner case: [1, 1], [0, 0]


public class Solution {
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}

		if (heights.length == 1) {
			return heights[0];
		}

		// the max area
		int max = 0;
		// increasing stack
		Stack<Integer> stack = new Stack<>();
		// i == heights.length is for dealing with the last bar
		// we assume that the histogram at index(heights.length) is -1
		// it is smaller than any histogram in the array
		for (int i = 0; i <= heights.length; i++) {
			// for corner case [0, 0], when index i == heights.length
			// if i == 0, then it is impossible to jump into the loop
			// moreover, since when i == heights.length, curt == -1
			// curt(-1) is the smallest one in the heights
			// all index in the stack needs to be caculated
			int curt = i == heights.length ? -1 : heights[i];
			while (!stack.empty() && heights[stack.peek()] > curt) {
				int h = heights[stack.pop()];
				// right bound(rn) of h is i, left bound(ln) of h is stack.peek()
				// e.g.:[2, 1, 5,   6,   2,  3]
				//			   ln   pop  rn
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				int area = h * w;
				max = Math.max(max, area);
			}
			stack.push(i);
		}
		return max;
	}
}
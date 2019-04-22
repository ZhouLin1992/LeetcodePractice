// https://leetcode.com/problems/find-the-celebrity/discuss/71240/AC-Java-solution-using-stack

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
        	stack.push(i);
        }

        int candidate1;
        int candidate2;

        while (stack.size() > 1) {
        	candidate1 = stack.pop();
        	candidate2 = stack.pop();

        	if (knows(candidate1, candidate2)) {
        		stack.push(candidate2);
        	} else {
        		stack.push(candidate1);
        	}
        }

        int candidate = stack.pop();

        for (int i = 0; i < n; i++) {
        	if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
        		return -1;
        	}
        }

        return candidate;
    }
}
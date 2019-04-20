/*
时间复杂度o(lgn + k)。
先找出大于target最小值，和小于target的最大值。只不过这次要用两个stack储存中间结果。
然后两个栈顶元素比较，取closer那个，pop出来，再把这个元素的左/右子树压栈（注释#）。直到找到k个结果。
如果一个栈空了，从另外一个栈pop出剩下的元素。

#：当lowbound的栈顶元素pop出来后，找次小于他的值，需要到他的左子树的右半边去找；
同理，当highbound的栈顶元素pop出来后，找略大于他的值，需要到他的右子树的左半边去找。
这是bst的性质决定的。其实和数组里面找k个临近值是一个原理，只不过数组通过两个指针左右移动就好。
二叉树要麻烦很多，用low和high两个指针把所有候选临近元素压栈，然后通过pop栈顶元素来从近向远pop比较。
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<TreeNode> lower = new LinkedList<>();
        Deque<TreeNode> upper = new LinkedList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val < target) {
                lower.push(curr);
                curr = curr.right;
            } else {
                upper.push(curr);
                curr = curr.left;
            }
        }

        List<Integer> result = new LinkedList<>();

        while (result.size() < k) {
            double lowerDiff = lower.isEmpty() ? Double.MAX_VALUE : target - lower.peek().val;
            double upperDiff = upper.isEmpty() ? Double.MAX_VALUE : upper.peek().val - target;

            if (lowerDiff < upperDiff) {
                result.add(lower.peek().val);
                getLower(lower);
            } else {
                result.add(upper.peek().val);
                getUpper(upper);
            }
        }

        return result;
    }

    private void getLower(Deque<TreeNode> lower) {
        if (lower.isEmpty()) {
            return;
        }

        TreeNode curr = lower.pop().left;
        while (curr != null) {
            lower.push(curr);
            curr = curr.right;
        }
    }

    private void getUpper(Deque<TreeNode> upper) {
        if (upper.isEmpty())  {
            return;
        }

        TreeNode curr = upper.pop().right;
        while (curr != null) {
            upper.push(curr);
            curr = curr.left;
        }
    }
}
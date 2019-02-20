/*
https://leetcode.com/problems/permutations-ii/discuss/18630/Java-Iterative-solution-no-Set-needed!

In each iteration, put the new number to all possible place.
To avoid duplicate we also have to:
1. For duplicate numbers in a row, only add same number in in front of them.
2. Break when same number exists in the permutation.

*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<Integer>());

        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (; size > 0; size--) {
                List<Integer> list = result.poll();
                for (int k = 0; k <= list.size(); k++) {
                    if (k > 0 && list.get(k - 1) == nums[i]) {
                        break;
                    }
                    List<Integer> tmp = new LinkedList<>(list);
                    tmp.add(k, nums[i]);
                    result.add(tmp);
                }
            }
        }

        return result;
    }
}
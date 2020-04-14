class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        combinationSum3(k, n, 1, result, new LinkedList<>());
        return result;
    }
    
    private void combinationSum3(int count, int target, int start, List<List<Integer>> result, List<Integer> curr) {
        if (count == 0 && target == 0) {
            result.add(new LinkedList<>(curr));
            return;
        }
        
        for (int i = start; i <= 9 && i <= target; i++) {
            curr.add(i);
            combinationSum3(count - 1, target - i, i + 1, result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
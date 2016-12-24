public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        generationHelper(0, 0, new StringBuilder(), res, n);
        return res;
    }
    
    // left: number of left paratheses
    // right: number of right paratheses
    private void generationHelper(int left, int right, StringBuilder str, List<String> res, int n) {
        // left < right means that we have added more than we can add
        if (left < right || left > n || right > n) {
            return;
        }
        
        if (str.length() == 2 * n) {
            res.add(str.toString());
        }
        
        str.append("(");
        generationHelper(left + 1, right, str, res, n);
        // backtracking
        str.setLength(str.length() - 1);
        
        str.append(")");
        generationHelper(left, right + 1, str, res, n);
        // backtracking
        str.setLength(str.length() - 1);
    }
}
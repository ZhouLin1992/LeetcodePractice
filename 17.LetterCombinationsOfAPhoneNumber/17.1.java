public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] set = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, set, new StringBuilder(), res, 0);
        return res;
    }
    
    private void helper(String digits, String[] set, StringBuilder sb, List<String> res, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            // always remember to "return"
            return;
        }
        
        int idx = Character.getNumericValue(digits.charAt(index));
        String alpha = set[idx];
        for (int i = 0; i < alpha.length(); i++) {
            sb.append(alpha.charAt(i));
            helper(digits, set, sb, res, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
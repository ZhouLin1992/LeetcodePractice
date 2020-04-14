class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new LinkedList<>();
        if (S == null || S.length() == 0) {
            return result;
        }

        helper(S.toCharArray(), result, 0);
        return result;
    }
    
    private void helper(char[] chs, List<String> result, int start) {
        if (start == chs.length) {
            result.add(new String(chs));
            return;
        }
        
        if (Character.isDigit(chs[start])) {
            helper(chs, result, start + 1);
            return;
        }
        
        chs[start] = Character.toLowerCase(chs[start]);
        helper(chs, result, start + 1);
        
        chs[start] = Character.toUpperCase(chs[start]);
        helper(chs, result, start + 1);
    }
}
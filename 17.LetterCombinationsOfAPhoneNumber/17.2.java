public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        res.add("");
        
        String[] set = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        for(int i = 0; i < digits.length(); i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while (res.getFirst().length() == i) {
                String tmp = res.removeFirst();
                char[] mappingSet = set[index].toCharArray();
                for (char ch: mappingSet) {
                    String t = tmp + ch;
                    res.addLast(t);
                }
            }
        }
        return res;
    }
}
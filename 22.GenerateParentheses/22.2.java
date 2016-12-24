// non-recursive version

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        res.add("()");
        
        for (int cnt = 1; cnt < n; cnt++) {
            Set<String> cache = new HashSet<>();
            for (int i = 0; i < res.size(); i++) {
                String str = res.get(i);
                for (int j = 0; j < str.length(); j++) {
                    cache.add(str.substring(0, j) + "()" + str.substring(j, str.length()));
                }
            }
            res.clear();
            res.addAll(cache);
        }
        
        return res;
    }
}
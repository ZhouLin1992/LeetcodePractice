// might be TLE

public class Solution {
    public static boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.isEmpty())
            return false;
        return wordBreak(s, wordDict, 0, false);
    }
    
    public static boolean wordBreak(String s, Set<String> wordDict, int start, boolean f) {
        boolean flag = f;
        if (start >= s.length())
        	return true;
        
        for (int i = start; i < s.length() && !flag; i++) {
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && !flag) {
                sb.append(s.charAt(i));
                // System.out.println(sb);
                if (wordDict.contains(sb.toString())) {
                    flag = wordBreak(s, wordDict, i + 1, false);
                    if (flag)
                    	return true;
                    else
                    	i++;
                }
                else 
                    i++;
            }
        }
        return flag;
    }
}
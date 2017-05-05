/*
hashMap stores (level, the length of the path up to level level) pairs. 
By default, we use a (0,0) to initialize the hashmap. But for example 
"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext".
dir is in level 1, not 0. subdir1 is in level 2, so on...
we update the hashMap using hashMap.get(level) + len + 1 because the 
current level is level+1, previous level is level, we +1 because the 
additional path separator char '/' , if s contains '.', we update the 
current max length
*/

public class Solution {
    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> mapping = new HashMap<>();
        mapping.put(0, 0);
        int result = 0;
        String[] parts = input.split("\n");
        for (String str: parts) {
            int level = str.lastIndexOf("\t") + 1;
            int len = str.length() - level;
            if (str.contains(".")) {
                result = Math.max(result, mapping.get(level) + len);
            } else {
                mapping.put(level + 1, mapping.get(level) + len + 1);
            }
        }
        return result;
    }
}
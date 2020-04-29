class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        
        startSet.add("0000");
        endSet.add(target);
        int level = 0;
        Set<String> tmp = new HashSet<>();
        
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            if (startSet.size() > endSet.size()) {
                Set<String> t = startSet;
                startSet = endSet;
                endSet = t;
            }
            
            tmp = new HashSet<>();
            
            for (String str : startSet) {
                if (endSet.contains(str)) {
                    return level;
                }
                
                if (deadSet.contains(str)) {
                    continue;
                }
                
                deadSet.add(str);
                
                for (int i = 0; i < 4; i++) {
                    char ch = str.charAt(i);
                    String next1 = str.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1) + str.substring(i + 1);
                    String next2 = str.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1) + str.substring(i + 1);
                    
                    if (!deadSet.contains(next1)) {
                        tmp.add(next1);
                    }
                    if (!deadSet.contains(next2)) {
                        tmp.add(next2);
                    }
                }
            }
            
            level++;
            startSet = tmp;
        }
        
        return -1;
    }
}
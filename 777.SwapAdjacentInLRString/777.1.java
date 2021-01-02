class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }
        
        int p1 = 0;
        int p2 = 0;
        
        while (p1 < start.length() && p2 < end.length()) {
            while (p1 < start.length() && start.charAt(p1) == 'X') {
                p1++;
            }
            
            while (p2 < end.length() && end.charAt(p2) == 'X') {
                p2++;
            }
            
            两个指针同时到达
            if (p1 == start.length() && p2 == end.length()) {
                return true;
            }
            
            // 其中一个指针先到达
            if (p1 == start.length() || p2 == end.length()) {
                return true;
            }
            
            if (start.charAt(p1) != end.charAt(p2)) {
                return false;
            }
            
            // 如果是R, p1只能<=p2
            if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            }
            
            // 如果是L, p2只能<=p1
            if (start.charAt(p1) == 'L' && p1 < p2) {
                return false;
            }
            
            p1++;
            p2++;
        }
        
        return true;
    }
}
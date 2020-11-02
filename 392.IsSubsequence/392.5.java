class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.computeIfAbsent(ch, list -> new ArrayList<>()).add(i);
        }
        
        int prev = -1;
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            } else {
                List<Integer> list = map.get(ch);
                prev = bs(list, prev);
                if (prev == -1) {
                    return false;
                }
                prev++;
            }
        }
        
        return true;
    }
    
    // find index >= prev
    private int bs(List<Integer> list, int prev) {
        int start = 0;
        int end = list.size() - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) == prev) {
                return list.get(mid);
            } else if (list.get(mid) < prev) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (list.get(start) >= prev) {
            return list.get(start);
        }
        if (list.get(end) >= prev) {
            return list.get(end);
        }
        return -1;
    }
}
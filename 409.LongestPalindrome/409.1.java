class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set.remove(ch);
                count++;
            } else {
                set.add(ch);
            }
        }

        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
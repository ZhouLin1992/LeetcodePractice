// https://leetcode.com/problems/shortest-word-distance-iii/discuss/67100/My-Concise-JAVA-Solution

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        boolean isSame = word1.equals(word2);
        int p1 = -1;
        int p2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (isSame) {
                    p2 = p1;
                }
                p1 = i;
            } else if (words[i].equals(word2)) {
                p2 = i;
            }

            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }

        return min;
    }
}
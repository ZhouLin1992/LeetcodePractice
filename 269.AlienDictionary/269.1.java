/*
Similar to Course Schedule Problem (LC 210)
Difference is that we need to build graph by comparing every consecutive pair of strings first,
then doing topological sort for the graph to get the result string

https://leetcode.com/problems/alien-dictionary/discuss/70119/Java-AC-solution-using-BFS
*/

class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        Set[] edges = new Set[26];
        Map<Character, Integer> inDegrees = new HashMap<>();

        // Initialize the map, to avoid null exception for those character that will have zero inDegrees(e.g, starting character)
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                inDegrees.put(ch, 0);
            }
        }

        // build graph, as well as fill out inDegree map for every character
        for (int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nextWord = words[i + 1];
            int minLen = Math.min(currWord.length(), nextWord.length());

            // traverse every pair of words, put each pair into graph map to build the map, update inDegree map
            // for every "nextChar", increase their inDegree by 1 every time
            for (int j = 0; j < minLen; j++) {
                char ch1 = currWord.charAt(j);
                char ch2 = nextWord.charAt(j);

                if (ch1 != ch2) {
                    if (edges[ch1 - 'a'] == null) {
                        edges[ch1 - 'a'] = new HashSet<Character>();
                    }

                    /* 
                        we must check if we already build curChar -> nextChar relationship in the graph
                        if it contains, we cannot update inDegree map again. Otherwise, this nextChar will
                        never be put in the queue when we do BFS traversal.
                        e.g. for input {"za", "zb", "ca", "cb"}, we have two pairs of a -> b, if we increase
                        inDegree value of 'b' again, the final result will not have 'b', since inDegree of 'b'
                        will stay on 1 when queue is empty
                    */
                    if (edges[ch1 - 'a'].add(ch2)) {
                        inDegrees.put(ch2, inDegrees.getOrDefault(ch2, 0) + 1);
                    }

                    // we can determine the order ot characters only by first different pair of characters
                    // we cannot proceed and add relationship for the rest of the characters in the string
                    break;
                }
            }
        }

        // we will have an input that has exact same format as course schedule
        // we can then use BFS to do topological sort
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            
            Set<Character> set = edges[curr - 'a'];
            
            if (set == null) {
                continue;
            }
            
            for (char ch : set) {
                int degrees = inDegrees.get(ch) - 1;
                if (degrees == 0) {
                    inDegrees.put(ch, 0);
                    queue.offer(ch);
                } else {
                    inDegrees.put(ch, degrees);
                }
            }
        }

        // check if input order is valid
        if (sb.length() != inDegrees.size()) {
            return "";
        }
        return sb.toString();
    }
}
// https://leetcode.com/problems/alien-dictionary/discuss/70115/3ms-Clean-Java-Solution-(DFS)

class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        
        Map<Character, Integer> visited = new HashMap<>();
        Map<Character, List<Character>> edges = new HashMap<>();
        
        buildGraph(words, visited, edges);
        
        StringBuilder sb = new StringBuilder();
        for (char ch : visited.keySet()) {
            if (visited.get(ch) == 0) {
                if (!dfs(sb, visited, edges, ch)) {
                    return "";
                }
            }
        }
        
        return sb.reverse().toString();
    }
    
    private void buildGraph(String[] words, Map<Character, Integer> visited, Map<Character, List<Character>> edges) {
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                visited.put(ch, 0);
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String currWord = words[i];
            String nextWord = words[i + 1];
            
            int minLen = Math.min(currWord.length(), nextWord.length());
            for (int j = 0; j < minLen; j++) {
                char ch1 = currWord.charAt(j);
                char ch2 = nextWord.charAt(j);
                
                if (ch1 != ch2) {
                    List<Character> edge = edges.get(ch1);
                    if (edge == null) {
                        edge = new ArrayList<>();
                        edges.put(ch1, edge);
                    }
                    edge.add(ch2);
                    break;
                }
            }
        }
    }
    
    private boolean dfs(StringBuilder sb, Map<Character, Integer> visited, Map<Character, List<Character>> edges, char ch) {
        if (visited.get(ch) == 2) {
            return true;
        }
        if (visited.get(ch) == 1) {
            return false;
        }
        
        if (edges.containsKey(ch)) {
            visited.put(ch, 1);
            for (char edge : edges.get(ch)) {
                if (!dfs(sb, visited, edges, edge)) {
                    return false;
                }
            }
        }
        
        visited.put(ch, 2);
        sb.append(ch);
        return true;
    }
}
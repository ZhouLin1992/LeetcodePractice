class Solution {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        return longestWord(trie);
    }
    
    private String longestWord(Trie trie) {
        String longest = "";
        
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(trie.root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TrieNode curr = queue.poll();
                for (int j = 25; j >= 0; j--) {
                    if (curr.children[j] != null && curr.children[j].isWord) {
                        longest = curr.children[j].word;
                        queue.offer(curr.children[j]);
                    }
                }
            }
        }
        
        return longest;
    }
}

class TrieNode {
    String word;
    boolean isWord;
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
        curr.word = word;
    }
}
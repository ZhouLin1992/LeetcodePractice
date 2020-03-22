class WordFilter {
    Trie trie;
    public WordFilter(String[] words) {
        if (words == null || words.length == 0) {
            return;
        }
        
        trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                trie.insert(word.substring(j, word.length()) + "{" + word, i);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        return trie.startsWith(suffix + "{" + prefix);
    }
}

class TrieNode {
    int weight;
    TrieNode[] children;
    public TrieNode() {
        // "{" is right after "z" in ASCII
        children = new TrieNode[27];
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word, int weight) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
            // 每一个trienode都需要设weight
            curr.weight = weight;
        }
    }
    
    public int startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            TrieNode next = curr.children[index];
            if (next == null) {
                return -1;
            }
            curr = next;
        }
        return curr.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
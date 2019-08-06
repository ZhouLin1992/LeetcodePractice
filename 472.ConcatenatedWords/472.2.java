class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new LinkedList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        
        TrieNode root = new TrieNode();
        for (String word : words) {
            if (word.length() != 0) {
                addTrieNode(word, root);
            }
        }
        
        for (String word : words) {
            if (word.length() != 0) {
                if (canForm(word.toCharArray(), 0, 0, root)) {
                    result.add(word);
                }    
            }
        }
        
        return result;
    }
    
    private void addTrieNode(String word, TrieNode root) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    
    private boolean canForm(char[] words, int startIndex, int count, TrieNode root) {
        TrieNode curr = root;
        int len = words.length;

        for (int i = startIndex; i < len; i++) {
            char ch = words[i];
            int index = ch - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            if (curr.children[index].isEnd) {
                // The concatenated word is not only formed by itself
                if (i == len - 1) {
                    return count >= 1;
                }
                // Start from Trie tree root and next character
                if (canForm(words, i + 1, count + 1, root)) {
                    return true;
                }
            }
            curr = curr.children[index];
        }
        
        return false;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}
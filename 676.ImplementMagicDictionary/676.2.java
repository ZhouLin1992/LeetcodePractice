class MagicDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isWord = true;
        }
    }
    
    private boolean searchHelper(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char ch = arr[i];
            for (char replace = 'a'; replace <= 'z'; replace++) {
                if (replace == ch) {
                    continue;
                }
                arr[i] = replace;
                String newString = new String(arr);
                if (searchHelper(newString)) {
                    return true;
                }
            }
            arr[i] = ch;
        }
        return false;
    }
    
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
class Trie {
	private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
    	root = new TrieNode();    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, TrieNode> childrenMap = root.children;
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
        	char ch = word.charAt(i);
        	if (childrenMap.containsKey(ch)) {
        		curr = childrenMap.get(ch);
        	} else {
        		curr = new TrieNode(ch);
        		childrenMap.put(ch, curr);
        	}
        	childrenMap = curr.children;
        }
        curr.hasWord = true;
    }

    private TrieNode find(String word) {
    	Map<Character, TrieNode> childrenMap = root.children;
    	TrieNode curr = root;

    	for (int i = 0; i < word.length(); i++) {
    		char ch = word.charAt(i);
    		curr = childrenMap.get(ch);
    		if (curr == null) {
    			return null;
    		}
    		childrenMap = curr.children;
    	}

    	return curr;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode node = find(word);
    	if (node == null || !node.hasWord) {
    		return false;
    	}
    	return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	return find(prefix) != null;
    }
}

class TrieNode {
	public Map<Character, TrieNode> children;
	public boolean hasWord;
	private char ch;

	public TrieNode() {
		children = new HashMap<>();
		hasWord = false;
	}

	public TrieNode(char _ch) {
		children = new HashMap<>();
		hasWord = false;
		ch = _ch;
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
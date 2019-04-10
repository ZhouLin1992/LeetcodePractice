class WordDictionary {
	private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
		TrieNode curr = root;    	

        for (int i = 0; i < word.length(); i++) {
        	char ch = word.charAt(i);
        	int pos = ch - 'a';

        	if (curr.children[pos] == null) {
        		curr.children[pos] = new TrieNode();
        	}

        	curr = curr.children[pos];
        }

        curr.hasWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return find(word, 0, root);
    }

    private boolean find(String word, int index, TrieNode curr) {
    	if (index == word.length()) {
    		return curr.hasWord;
    	}

    	char ch = word.charAt(index);
    	if (ch == '.') {
    		for (int i = 0; i < 26; i++) {
    			if (curr.children[i] != null) {
	    			if (find(word, index + 1, curr.children[i])) {
	    				return true;
	    			}
    			}
    		}

    		return false;
    	} else if (curr.children[ch - 'a'] != null) {
    		return find(word, index + 1, curr.children[ch - 'a']);
    	} else {
    		return false;
    	}
    }
}

class TrieNode {
	public boolean hasWord;
	public TrieNode[] children;

	public TrieNode() {
		hasWord = false;
		children = new TrieNode[26];
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
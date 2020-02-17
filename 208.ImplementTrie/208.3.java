class Trie {
	TrieNode root;
	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			if (curr.children[index] == null) {
				curr.children[index] = new TrieNode();
			}
			curr = curr.children[index];
		}
		curr.hasWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			if (curr.children[index] == null) {
				return false;
			}
			curr = curr.children[index];
		}

		return curr.hasWord;
	}

	/** Returns if there is any word in the trie that starts with the given prefix. */
	public boolean startsWith(String prefix) {
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char ch = prefix.charAt(i);
			int index = ch - 'a';
			if (curr.children[index] == null) {
				return false;
			}
			curr = curr.children[index];
		}
		return true;
	}

	class TrieNode {
		final int numAlpha = 26;
		TrieNode[] children;
		boolean hasWord;

		public TrieNode() {
			children = new TrieNode[numAlpha];
		}
	}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
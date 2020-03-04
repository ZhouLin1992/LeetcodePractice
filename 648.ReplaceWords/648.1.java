class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0 || sentence == null || sentence.length() == 0) {
            return sentence;
        }

        TrieNode root = buildTrie(dict);

        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            result.append(replaceWordsHelper(root, word));
            result.append(" ");
        }
        
        return result.substring(0, result.length() - 1);
    }
    
    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String str : dict) {
            TrieNode curr = root;
            for (char ch : str.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isWord = true;
        }
        return root;
    }
    
    private String replaceWordsHelper(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder result = new StringBuilder();
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            result.append(ch);
            if (curr.children[index] != null) {
                if (curr.children[index].isWord) {
                    return result.toString();
                }
                curr = curr.children[index];
            } else {
                return word;
            }
        }
        return word;
    }
}

class TrieNode {
    final int numAlpha = 26;
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode() {
        children = new TrieNode[numAlpha];
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        
        // build trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word, 0);
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, root, result, r, c);
            }
        }
        
        return result;
    }
    
    private void dfs(char[][] board, TrieNode root, List<String> result, int r, int c) {
        char ch = board[r][c];
        if (ch == '#' || root.next[ch - 'a'] == null) {
            return;
        }
        TrieNode curr = root.next[ch - 'a'];
        if (curr.word != null) {
            result.add(curr.word);
            // de-duplicate
            curr.word = null;
            // do not return here; the current word can still be prefix of other words
        }
        
        board[r][c] = '#';
        if (r > 0) {
            dfs(board, curr, result, r - 1, c);
        }
        if (c > 0) {
            dfs(board, curr, result, r, c - 1);
        }
        if (r < board.length - 1) {
            dfs(board, curr, result, r + 1, c);
        }
        if (c < board[0].length - 1) {
            dfs(board, curr, result, r, c + 1);
        }
        // back tracking
        board[r][c] = ch;
    }
}

class TrieNode {
    TrieNode[] next;
    String word;
    
    public TrieNode() {
        next = new TrieNode[26];
    }
    
    public void insert(String word, int index) {
        if (index == word.length()) {
            this.word = word;
            return;
        }
        
        int pos = word.charAt(index) - 'a';
        if (next[pos] == null) {
            next[pos] = new TrieNode();
        }
        next[pos].insert(word, index + 1);
    }
}
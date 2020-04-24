class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        
        // build trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
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
        if (ch == '#' || root.next.get(ch) == null) {
            return;
        }
        TrieNode curr = root.next.get(ch);
        if (curr.word != null) {
            result.add(curr.word);
            // de-duplicate
            curr.word = null;
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
    Map<Character, TrieNode> next;
    String word;
    
    public TrieNode() {
        next = new HashMap<>();
    }
    
    public void insert(String word) {
        TrieNode curr = null;
        Map<Character, TrieNode> childNext = next;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (childNext.containsKey(ch)) {
                curr = childNext.get(ch);
            } else {
                TrieNode newNode = new TrieNode();
                childNext.put(ch, newNode);
                curr = newNode;
            }
            childNext = curr.next;
        }
        curr.word = word;
    }
}
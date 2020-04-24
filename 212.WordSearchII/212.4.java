/**
Time: O(m*n*4^l), l是字母平均的长度
Space: O(sum(l))
**/

class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.addWord(word);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(result, i, j, board, trie.root);
            }
        }
        
        return result;
    }
    
    private void search(List<String> result, int r, int c, char[][] board, TrieNode curr) {
        // 越界
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#') {
            return;
        }
        
        int index = board[r][c] - 'a';
        TrieNode next = curr.children[index];
        if (next == null) {
            return;
        }
        
        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        char prev = board[r][c];
        board[r][c] = '#';
        for (int j = 0; j < 4; j++) {
            search(result, r + dx[j], c + dy[j], board, next);
        }
        board[r][c] = prev;
    }
}

class TrieNode {
    TrieNode[] children;
    String word;
    
    public TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void addWord(String str) {
        TrieNode curr = root;
        for (char ch : str.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.word = str;
    }
}
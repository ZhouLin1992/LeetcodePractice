public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        
        TrieTree dict = new TrieTree();
        
        for (String word: words) {
            dict.insert(word);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // to do
                search(board, dict.root, i, j, res);
            }
        }
        
        return res;
    }
    
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    
    private void search(char[][] board, TrieNode root, int i, int j, List<String> res) {
        if (root == null) {
            return;
        }
        
        // if here is the end of a word
        // and this word has not been added
        if (root.isString) {
            if (!res.contains(root.str)) {
                res.add(root.str);
            }
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        // if the index is out of bound
        // or the index has been visited
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == '#') {
            return;
        }
        
        // if the TrieNode has not been inserted
        if (!root.children.containsKey(board[i][j])) {
            return;
        }
        
        // traverse up, down, left, right
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            char cur = board[i][j];
            // mark it has been visited
            board[i][j] = '#';
            search(board, root.children.get(cur), x, y, res);
            board[i][j] = cur;
        }
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isString;
    String str;
    public TrieNode() {
        children = new HashMap<>();
        isString = false;
        str = "";
    }
}

class TrieTree {
    TrieNode root;
    public TrieTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.isString = true;
        cur.str = word;
    }
    
    public boolean find(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return cur.isString;
    }
}
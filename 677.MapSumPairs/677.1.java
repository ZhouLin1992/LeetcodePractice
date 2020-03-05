class MapSum {
    TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode curr = root;
        Map<Character, TrieNode> children = curr.children;
        for (char ch : key.toCharArray()) {
            TrieNode node = children.get(ch);
            if (node == null) {
                node = new TrieNode();
                children.put(ch, node);
            }
            curr = node;
            children = curr.children;
        }
        curr.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        Map<Character, TrieNode> children = curr.children;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = children.get(ch);
            if (node == null) {
                return 0;
            }
            curr = node;
            children = curr.children;
        }
        return dfs(curr);
    }
    
    private int dfs(TrieNode curr) {
        int sum = curr.val;
        for (char ch : curr.children.keySet()) {
            sum += dfs(curr.children.get(ch));
        }
        return sum;
    }
}

class TrieNode {
    int val;
    Map<Character, TrieNode> children;
    public TrieNode() {
        children = new HashMap<>();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
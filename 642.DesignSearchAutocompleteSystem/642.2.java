class AutocompleteSystem {
    private TrieNode root;
    private String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        
        for (int i = 0; i < times.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    private void add(String str, int count) {
        TrieNode curr = root;
        for (char ch : str.toCharArray()) {
            TrieNode next = curr.children.get(ch);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(ch, next);
            }
            curr = next;
            curr.counts.put(str, curr.counts.getOrDefault(str, 0) + count);
        }
        curr.isWord = true;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        
        prefix += c;
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode next = curr.children.get(ch);
            if (next == null) {
                return new ArrayList<>();
            }
            curr = next;
        }
        
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> (a.count == b.count ? a.str.compareTo(b.str) : b.count - a.count));
        for (String s : curr.counts.keySet()) {
            pq.offer(new Pair(s, curr.counts.get(s)));
        }
        
        List<String> result = new LinkedList<>();
        while (!pq.isEmpty() && result.size() < 3) {
            result.add(pq.poll().str);
        }
        
        return result;
    }
}

class Pair {
    String str;
    int count;
    public Pair(String str, int count) {
        this.str = str;
        this.count = count;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> counts;
    boolean isWord;
    public TrieNode() {
        children = new HashMap<>();
        counts = new HashMap<>();
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
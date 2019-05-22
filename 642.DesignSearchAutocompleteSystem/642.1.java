class AutocompleteSystem {
    private Map<String, Integer> map;
    private String word;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        word = "";
        
        for (int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            map.put(word, map.getOrDefault(word, 0) + 1);
            word = "";
            return new ArrayList<>();
        }
        
        word += c;
        Queue<Pair> queue = new PriorityQueue<>((a, b) -> (a.count == b.count ? a.str.compareTo(b.str) : b.count - a.count));
        for (String str : map.keySet()) {
            if (str.startsWith(word)) {
                queue.offer(new Pair(str, map.get(str)));
            }
        }
        
        List<String> result = new LinkedList<>();
        while (!queue.isEmpty() && result.size() < 3) {
            result.add(queue.poll().str);
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

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
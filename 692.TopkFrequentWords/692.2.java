class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        // min heap
        Queue<String> pq = new PriorityQueue<>((w1, w2) -> counts.get(w1).equals(counts.get(w2)) ? w2.compareTo(w1) : counts.get(w1) - counts.get(w2));
        
        for (String str : counts.keySet()) {
            pq.offer(str);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        LinkedList<String> result = new LinkedList<>();
        while (pq.size() > 0) {
            result.addFirst(pq.poll());
        }
        
        return result;
    }
}
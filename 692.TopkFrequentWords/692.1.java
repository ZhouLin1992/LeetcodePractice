class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        List<String> list = new ArrayList<>(counts.keySet());
        Collections.sort(list, (w1, w2) -> counts.get(w1).equals(counts.get(w2)) ? w1.compareTo(w2) : counts.get(w2) - counts.get(w1));
        
        return list.subList(0, k);
    }
}
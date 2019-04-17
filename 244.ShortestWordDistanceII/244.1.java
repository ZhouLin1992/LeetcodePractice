class WordDistance {
	private Map<String, List<Integer>> dictionary;
    public WordDistance(String[] words) {
        dictionary = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
        	List<Integer> list = dictionary.get(word);
        	if (list == null) {
        		list = new ArrayList<Integer>();
        	}
        	list.add(i);
        	dictionary.put(word, list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = dictionary.get(word1);
        List<Integer> l2 = dictionary.get(word2);
        int min = Integer.MAX_VALUE;

        for (int i1 = 0, i2 = 0; i1 < l1.size() && i2 < l2.size();) {
        	int index1 = l1.get(i1);
        	int index2 = l2.get(i2);

        	if (index1 < index2) {
        		min = Math.min(min, Math.abs(index2 - index1));
        		i1++;
        	} else {
        		min = Math.min(min, Math.abs(index1 - index2));
        		i2++;
        	}
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
class WordDistance {
	private Map<String, TreeSet<Integer>> dict;
    public WordDistance(String[] words) {
        dict = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
        	String word = words[i];
        	TreeSet<Integer> set = dict.get(word);
        	if (set == null) {
        		set = new TreeSet<>();
        		dict.put(word, set);
        	}
        	set.add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        TreeSet<Integer> set1 = dict.get(word1);
        TreeSet<Integer> set2 = dict.get(word2);
        int min = Integer.MAX_VALUE;

        for (int i : set1) {
        	Integer ceiling = set2.ceiling(i);
        	Integer floor = set2.floor(i);

        	if (ceiling != null) {
        		min = Math.min(min, Math.abs(ceiling - i));
        	}
        	if (floor != null) {
        		min = Math.min(min, Math.abs(floor - i));
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
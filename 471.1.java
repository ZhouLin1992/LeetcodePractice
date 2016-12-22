class pair {
	String key;
	int count;
	public pair(String key, int count) {
		this.key = key;
		this.count = count;
	}
}

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */

    // self define a comparator
	private Comparator<pair> pairComparator = new Comparator<pair>() {
    	public int compare(pair p1, pair p2) {
    		// pq stores the higher count
    		if (p1.count != p2.count) {
    			return p1.count - p2.count;
    		}
    		// when count equals, pq stores the lower alphabet
    		return p2.key.compareTo(p1.key);
    	}
	};
     
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
		if (words == null || words.length == 0 || k <= 0) {
			return new String[0];
		}

		if (words.length < k) {
			return null;
		}

		// O(N) time
		// count frequency of different String
		HashMap<String, Integer> hm = new HashMap<>();
		for (String str: words) {
			if (hm.containsKey(str)) {
			    hm.put(str, hm.get(str) + 1);
			} else {
			    hm.put(str, 1);
			}
		}

		// use min heap to store the top K String, every new pair compared
		// with the String with minimum count so far: it new pair is smaller
		// it can not be inserted into min heap; Ohterwise, poll() the minimum
		// and insert the new pair into min heap
		// O(Nlogk), k is also the capacity of PriorityQueue
		Queue<pair> pq = new PriorityQueue<pair>(k, pairComparator);
		for (String str: hm.keySet()) {
			pair newPair = new pair(str, hm.get(str));
			if (pq.size() < k) {
				pq.add(newPair);
			} else {
				pair peak = pq.peek();
				if (pairComparator.compare(peak, newPair) < 0) {
					pq.poll();
					pq.add(newPair);
				}
			}
		}

		// stores the String into array
		// O(klogk)
		String[] res = new String[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = pq.poll().key;
		}
		return res;
	}
}

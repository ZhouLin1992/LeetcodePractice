class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
		int index = -1;
		int min = words.length;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (index != -1 && !words[index].equals(words[i])) {
					min = Math.min(min, Math.abs(index - i));
				}
				index = i;
			}
		}

		return min;
    }
}
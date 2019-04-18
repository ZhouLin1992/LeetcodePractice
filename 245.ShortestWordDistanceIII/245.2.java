class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
		int index = -1;
		int min = words.length;
		boolean isSameWord = word1.equals(word2);

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (index != -1 && (isSameWord || !words[i].equals(words[index]))) {
					min = Math.min(Math.abs(index - i), min);
				}
				index = i;
			}
		}

		return min;
    }
}
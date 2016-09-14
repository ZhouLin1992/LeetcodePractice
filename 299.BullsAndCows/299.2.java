public class Solution {
	public String getHint(String secret, String guess) {
		if (secret.length() == 0 || guess.length() == 0 || secret.length() != guess.length())
			return "";

		char[] s = secret.toCharArray();
		char[] g = guess.toCharArray();
		int[] tmp = new int[10];
		int bulls = 0, cows = 0, sInd, gInd;

		for (int i = 0; i < secret.length(); i++) {
			sInd = s[i] - '0';
			gInd = g[i] - '0';

			if (sInd == gInd) bulls++;
			else {
				if (tmp[sInd] < 0) cows++;
				tmp[sInd]++;
				if (tmp[gInd] > 0) cows++;
				tmp[gInd]--;
			}			
		}
		return bulls + "A" + cows + "B";	
	}
}
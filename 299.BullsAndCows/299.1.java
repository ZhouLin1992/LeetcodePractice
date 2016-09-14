public class Solution {
    public String getHint(String secret, String guess) {
		if (secret.length() == 0 || guess.length() == 0 || secret.length() != guess.length()) return "";

		int bulls = 0, cows = 0;
		char[] s = secret.toCharArray();
		char[] g = guess.toCharArray();
		int[] stmp = new int[10];
		int[] gtmp = new int[10];

		for (int i = 0; i < secret.length(); i++) {
			if (s[i] == g[i]) bulls++;
			else {
				stmp[s[i] - '0']++;
				gtmp[g[i] - '0']++;
				// if (stmp[sInd] - gtmp[sInd] == 0) {
				// 	cows++;
				// 	stmp[sInd] = 0;
				// 	gtmp[sInd] = 0;
				// }
				// if (sInd != gInd && stmp[gInd] - gtmp[gInd] == 0) {
				// 	cows++;
				// 	stmp[gInd] = 0;
				// 	gtmp[gInd] = 0;
				// }
			}
		}

		for (int j = 0; j < 10; j++) {
			if (stmp[j] != 0 && gtmp[j] != 0)
				cows += Math.min(stmp[j], gtmp[j]);
		}

		return bulls + "A" + cows + "B";
    }
}
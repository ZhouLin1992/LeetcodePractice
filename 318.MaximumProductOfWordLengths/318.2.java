public class Solution {
    public int maxProduct(String[] words) {
		if (words.length == 0 || words == null) return 0;

		int len = words.length;
		int[] lens = new int[len];
		int[] bitMask = new int[len];
		for (int i = 0; i < len; i++) {
		    int num = 0;
			String tmp = words[i];
			lens[i] = tmp.length();
			for (int j = 0; j < lens[i]; j++)
				num |= 1 << (tmp.charAt(j) - 'a');
			bitMask[i] = num;
		}

		int res = 0;
		for (int k = 0; k < len; k++) 
			for (int p = k + 1; p < len; p++)
				if ((bitMask[k] & bitMask[p]) == 0)
					if (res < lens[k] * lens[p])
						res = lens[k] * lens[p];
		return res;      
    }
}
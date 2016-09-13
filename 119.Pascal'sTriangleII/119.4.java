public class Solution {
    public List<Integer> getRow(int rowIndex) {
		int[] prev = new int[rowIndex + 1];
		int[] curr = new int[rowIndex + 1];
		
		prev[0] = 1;

		for (int row = 1; row <= rowIndex; row++) {
			for (int i = 0; i <= row; i++) {
				if (i == 0 || i == row) curr[i] = 1;
				else curr[i] = prev[i - 1] + prev[i];
			}
			int[] swap = curr;
			curr = prev;
			prev = swap;
		}

		List<Integer> res = new ArrayList<Integer>();
		for (int i: prev) 
			res.add(i);
		return res;
    }
}
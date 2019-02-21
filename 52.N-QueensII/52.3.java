// no global parameter usage, e.g. count

class Solution {
    public int totalNQueens(int n) {
    	boolean[] hill = new boolean[2 * n];
    	boolean[] dale = new boolean[2 * n];
    	boolean[] row = new boolean[n];
    	return totalNQueens(hill, dale, row, 0, n);
    }

    private int totalNQueens(boolean[] hill, boolean[] dale, boolean[] row, int col, int n) {
    	int count = 0;

    	for (int i = 0; i < n; i++) {
    		int id1 = col - i + n;
    		int id2 = i + col;
    		if (!hill[id1] && !dale[id2] && !row[i]) {
                // Note: not i, it's col
    			if (col == n - 1) {
    				count++;
    			} else {
    				hill[id1] = true;
    				dale[id2] = true;
    				row[i] = true;
    				count += totalNQueens(hill, dale, row, col + 1, n);
    				hill[id1] = false;
    				dale[id2] = false;
    				row[i] = false;
    			}
    		}
    	}

    	return count;
    }
}
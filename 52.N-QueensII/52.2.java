/*
https://leetcode.com/problems/n-queens-ii/discuss/20048/Easiest-Java-Solution-(1ms-98.22)

time: o(n!)
space: o(n)
*/

class Solution {
	// use global parameter
	int count = 0;
    public int totalNQueens(int n) {
		boolean[] hill = new boolean[2 * n]; // diagonal "/"
		boolean[] dale = new boolean[2 * n]; // diagonal "\"
		boolean[] rows = new boolean[n]; // in each row, there is one cell already occupied by Queen
		totalNQueens(hill, dale, rows, 0, n);
		return count;
    }

    private void totalNQueens(boolean[] hill, boolean[] dale, boolean[] rows, int col, int n) {
    	if (col == n) {
    		count++;
            return;
    	}

    	for (int i = 0; i < n; i++) {
    		int id1 = col - i + n;
    		int id2 = i + col;
    		if (hill[id1] || dale[id2] || rows[i]) {
    			continue;
    		}

    		hill[id1] = true;
    		dale[id2] = true;
    		rows[i] = true;
    		totalNQueens(hill, dale, rows, col + 1, n);
    		hill[id1] = false;
    		dale[id2] = false;
    		rows[i] = false;
    	}
    }
}
// https://leetcode.com/problems/flatten-2d-vector/discuss/67656/Java-Solution-Beats-60.10

class Vector2D {
	int[][] data;
	int row;
	int col;

    public Vector2D(int[][] v) {
		data = v;
		row = 0;
		col = 0;
    }
    
    public int next() {
        if (!hasNext()) {
            return Integer.MAX_VALUE;
        }
    	return data[row][col++];
    }
    
    public boolean hasNext() {
    	while (row < data.length) {
    		if (col < data[row].length) {
    			return true;
    		} else {
    			row++;
    			col = 0;
    		}
    	}
    	return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
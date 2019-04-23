// https://www.jiuzhang.com/solution/flatten-2d-vector/#tag-other

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
        while (row < data.length && col == data[row].length) {
            row++;
            col = 0;
        }
        return row < data.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
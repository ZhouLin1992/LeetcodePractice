public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}

		// number of row/column
		int rows = matrix.length;
		int cols = matrix[0].length;

		int visitedRows = 0;
		int visitedColumns = 0;

		// start coordinates
		int startx = 0, starty = 0;

		// direction: 0 right, 1 down, 2 left, 3 up
		int direct = 0;

		// x: 1 -> right +1, -1 -> left -1
		int[] x = {1, 0, -1, 0};

		// y: 1 -> down +1, -1 -> up -1
		int[] y = {0, 1, 0, -1};

		int candidateNum = 0;
		int step = 0;

		while(true) {
			// 表示做的是列操作，关心行的数量
			if (x[direct] == 0) {
				candidateNum = rows - visitedRows;
			} else {
				candidateNum = cols - visitedColumns;
			}

			if (candidateNum <= 0) {
				break;
			}

			res.add(matrix[startx][starty]);
			step++;

			// 表示这个方向走完了
			if(step == candidateNum) {
				visitedRows += x[direct] == 0 ? 0 : 1;
				visitedColumns += y[direct] == 0 ? 0 : 1;
				step = 0;
				direct++;
				direct %= 4;
			}

			startx += y[direct];
			starty += x[direct];
		}
		return res;
	}
}
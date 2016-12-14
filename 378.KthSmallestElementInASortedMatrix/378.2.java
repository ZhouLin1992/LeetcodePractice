public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		Queue<Element> pq = new PriorityQueue<>(matrix.length, new Comparator<Element>() {
			public int compare(Element e1, Element e2) {
				return e1.val - e2.val;
			}
		});

		// insert the first column
		for (int i = 0; i < matrix.length; i++) {
			pq.add(new Element(matrix[i][0], i, 0));
		}

		// repeat the process for (k - 1) times
		// every time you poll the root out of the priorityqueue
		// get its row index and column index
		// replace the root with the next element from the same row
		for (int i = 0; i < k - 1; i++) {
			Element tmp = pq.poll();
			if (tmp.col == matrix[0].length - 1) {
				continue;
			}
			pq.add(new Element(matrix[tmp.row][tmp.col + 1], tmp.row, tmp.col + 1));
		}

		return pq.poll().val;
	}
}

class Element {
	int val;
	int row;
	int col;
	public Element(int val, int row, int col) {
		this.val = val;
		this.row = row;
		this.col = col;
	}
}
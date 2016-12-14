public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
		// Min Heap
		Queue<Element> pq = new PriorityQueue<>(matrix[0].length, new Comparator<Element>() {
			public int compare(Element e1, Element e2) {
				return e1.val - e2.val;
			}
		});

		// put the first row in pq
		for (int c = 0; c < matrix[0].length; c++) {
			pq.add(new Element(matrix[0][c], 0, c));
		}


		// repeat (k - 1) times
		// poll the minimum element so far
		// insert the element with the (row + 1, col)
		for (int i = 0; i < k - 1; i++) {
			Element ele = pq.poll();
			if (ele.row == matrix.length - 1) {
				continue;
			}
			pq.add(new Element(matrix[ele.row + 1][ele.col], ele.row + 1, ele.col));	
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
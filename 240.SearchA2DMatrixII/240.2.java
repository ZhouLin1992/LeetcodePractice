// https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/148444/Java-Solution-using-Binary-Search-(with-comments)-(96)
// https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/240184/Java-Divide-and-Conquer-approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int startX, int startY, int endX, int endY) {
    	if (startX > endX || startY > endY || startX < 0 || startY < 0 || endX >= matrix.length || endY >= matrix[0].length) {
    		return false;
    	}

    	int midX = startX + (endX - startX) / 2;
    	int midY = startY + (endY - startY) / 2;
    	int midValue = matrix[midX][midY];

    	if (target == midValue) {
    		return true;
    	} else if (target < midValue) {
    		return searchMatrix(matrix, target, startX, startY, endX, midY - 1) || searchMatrix(matrix, target, startX, startY, midX - 1, endY);
    	} else {
    		return searchMatrix(matrix, target, midX + 1, startY, endX, endY) || searchMatrix(matrix, target, startX, midY + 1, endX, endY);
    	}
    }
}
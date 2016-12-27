public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        // use left, right, top, down to mark 4 corners
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        
        // >= not >, when there is only one row/column
        // if it is >, it won't jump into the loop
        while (right >= left && down >= top) {
            
            // top whole row
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            
            // right column
            for (int i = top + 1; i < down; i++) {
                res.add(matrix[i][right]);
            }
            
            // down whole row
            if (top != down) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
            } 
            
            // left column
            if (left != right) {
                for (int i = down - 1; i > top; i--) {
                    res.add(matrix[i][left]);
                }              
            }

            left++;
            right--;
            top++;
            down--;
        }
        
        return res;
    }
}
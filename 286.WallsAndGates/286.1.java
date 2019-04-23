/*
BFS:
The round robin approach taken between the set of zeros encountered in the 'rooms' array helps ensure that 
each INF is updated with a distance from its nearest 0 (rather than just any 0)

space: o(MN)
time: o(MN)
*/

class Solution {
    public void wallsAndGates(int[][] rooms) {
    	if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
    		return;
    	}
    	Queue<int[]> queue = new LinkedList<>();
    	int rows = rooms.length;
    	int cols = rooms[0].length;
    	for (int r = 0; r < rows; r++) {
    		for (int c = 0; c < cols; c++) {
    			if (rooms[r][c] == 0) {
    				queue.offer(new int[]{r, c});
    			}
    		}
    	}

    	int row;
    	int col;
    	while (!queue.isEmpty()) {
    		int[] curr = queue.poll();
    		row = curr[0];
    		col = curr[1];

    		if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
    			rooms[row - 1][col] = rooms[row][col] + 1;
    			queue.offer(new int[]{row - 1, col});
    		}

    		if (row < rows - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
    			rooms[row + 1][col] = rooms[row][col] + 1;
    			queue.offer(new int[]{row + 1, col});
    		}

    		if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
    			rooms[row][col - 1] = rooms[row][col] + 1;
    			queue.offer(new int[]{row, col - 1});
    		}

    		if (col < cols - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
    			rooms[row][col + 1] = rooms[row][col] + 1;
    			queue.offer(new int[]{row, col + 1});
    		}
    	}
    }
}
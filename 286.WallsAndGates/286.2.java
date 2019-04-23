// DFS

class Solution {
    public void wallsAndGates(int[][] rooms) {
		for (int r = 0; r < rooms.length; r++) {
			for (int c = 0; c < rooms[0].length; c++) {
				if (rooms[r][c] == 0) {
					dfs(rooms, r, c, 0);
				}
			}
		}
    }

    private void dfs(int[][] rooms, int row, int col, int distance) {
    	/*
		the condition rooms[i][j]<d solves 3 problems:
		(1) do not update walls & gates (-1 & 0s);
		(2) distinguish the visited and not-visited nodes (the visited can only have smaller distance);
		(3) stop earlier when you find the previous gate has given shorter distance than the current one.
    	*/
    	if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || rooms[row][col] < distance) {
    		return;
    	}

    	rooms[row][col] = distance;
    	dfs(rooms, row + 1, col, distance + 1);
    	dfs(rooms, row - 1, col, distance + 1);
    	dfs(rooms, row, col + 1, distance + 1);
    	dfs(rooms, row, col - 1, distance + 1);
    }
}
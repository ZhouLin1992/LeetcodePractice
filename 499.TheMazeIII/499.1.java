class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return "";
        }
        
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] dm = {"l", "r", "u", "d"};

        Queue<Coordinate> queue = new PriorityQueue<>(new Comparator<Coordinate>() {
            public int compare(Coordinate c1, Coordinate c2) {
                if (c1.dist != c2.dist) {
                    return c1.dist - c2.dist;
                }
                return c1.moves.compareTo(c2.moves);
            }
        });
        queue.offer(new Coordinate(ball[0], ball[1], 0, ""));
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            
            if (curr.x == hole[0] && curr.y == hole[1]) {
                return curr.moves;
            }
            
            if (visited[curr.x][curr.y]) {
                continue;
            }
            
            visited[curr.x][curr.y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x;
                int nextY = curr.y;
                int nextDist = curr.dist;
                while (isValid(nextX + dx[i], nextY + dy[i], maze)) {
                    nextX += dx[i];
                    nextY += dy[i];
                    nextDist++;
                    if (nextX == hole[0] && nextY == hole[1]) {
                        break;
                    }
                }
                queue.offer(new Coordinate(nextX, nextY, nextDist, curr.moves + dm[i]));
            }
        }
        return "impossible";
    }
    
    private boolean isValid(int x, int y, int[][] maze) {
        if (0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
            return true;
        }
        return false;
    }
}

class Coordinate {
    int x;
    int y;
    int dist;
    String moves;
    
    public Coordinate(int _x, int _y, int _dist, String _moves) {
        x = _x;
        y = _y;
        dist = _dist;
        moves = _moves;
    }
}
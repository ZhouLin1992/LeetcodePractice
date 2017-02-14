/*
用heap保存最外围的点，并且快速求得最小值
用一个visited matrix保存visit过的点
每次得到最外围的最小值，然后往内灌水（四个方向）
从matrix四周开始考虑，发现matrix能Hold住的水，取决于height低的block。
必须从外围开始考虑，因为水是被包裹在里面，外面至少需要现有一层。

1.能装水的底面肯定不能在边界上，因为边界上的点无法封闭，那么所有边界上的点都可以加入queue，
当作BFS的启动点。
2.同时我们需要一个二维数组来标记访问过的点。
3.为了成功的装进去水，周围的高度都应该比当前的高度高，形成一个凹槽才能装水，
而且装水量取决于周围最小的那个高度，有点像木桶原理的感觉，因此queue就不能使用普通队列了，
而是使用优先级队列，将高度小的放在队首，最先取出
4.向周围BFS搜索的条件是不能越界，且周围格子未被访问。
5.由于我们没有特别声明高度相同的格子在优先队列queue中的顺序，所以应该是随机的，
其实谁先遍历到都一样，对结果没啥影响

时间复杂度：O(NMlog(2N+2M)),N,M为输入矩阵的长宽
空间复杂度：O(NM)
*/

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        
        Queue<Cell> pq = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
            public int compare(Cell c1, Cell c2) {
                return c1.height - c2.height;
            }
        });
        
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // first column and last column
        for (int r = 0; r < rows; r++) {
            pq.offer(new Cell(r, 0, heightMap[r][0]));
            visited[r][0] = true;
            pq.offer(new Cell(r, cols - 1, heightMap[r][cols - 1]));
            visited[r][cols - 1] = true;
        }
        
        // first row and last row
        for (int c = 0; c < cols; c++) {
            pq.offer(new Cell(0, c, heightMap[0][c]));
            visited[0][c] = true;
            pq.offer(new Cell(rows - 1, c, heightMap[rows - 1][c]));
            visited[rows - 1][c] = true;
        }
        
        // up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int res = 0;
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int i = 0; i < 4; i++) {
                int x = cell.x + dx[i];
                int y = cell.y + dy[i];
                if (0 <= x && x < rows && 0 <= y && y < cols && !visited[x][y]) {
                    pq.offer(new Cell(x, y, Math.max(heightMap[x][y], cell.height)));
                    visited[x][y] = true;
                    res += Math.max(0, cell.height - heightMap[x][y]);
                }
            }
        }
        
        return res;
    }
}

class Cell {
    int x;
    int y;
    int height;
    Cell(int _x, int _y, int _height) {
        this.x = _x;
        this.y = _y;
        this.height = _height;
    }
}
class Solution {
    private Comparator<Coordinate> coorComparator = new Comparator<Coordinate>(){
        @Override
        public int compare(Coordinate c1, Coordinate c2) {
            return (c1.x * c1.x + c1.y * c1.y) - (c2.x * c2.x + c2.y * c2.y);
        }
    };
    
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0].length == 0) {
        	return new int[0][0];
        }

        Queue<Coordinate> pq = new PriorityQueue<Coordinate>(coorComparator);

        for (int[] coor : points) {
        	pq.offer(new Coordinate(coor[0], coor[1]));
        }

       	int[][] result = new int[K][2];
       	for (int i = 0; i < K; i++) {
       		Coordinate coor = pq.poll();
       		result[i][0] = coor.x;
       		result[i][1] = coor.y;
       	}

       	return result;
    }
}

class Coordinate {
    int x;
    int y;
    public Coordinate(int _x, int _y) {
        x = _x;
        y = _y;
    }
}
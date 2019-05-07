class Solution {
    private Comparator<int[]> coorComparator = new Comparator<int[]>(){
        @Override
        public int compare(int[] arr1, int[] arr2) {
            return (arr1[0] * arr1[0] + arr1[1] * arr1[1]) - (arr2[0] * arr2[0] + arr2[1] * arr2[1]);
        }
    };
    
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0].length == 0) {
        	return new int[0][0];
        }

        Queue<int[]> pq = new PriorityQueue<int[]>(coorComparator);

        for (int[] arr : points) {
        	pq.offer(arr);
        }

       	int[][] result = new int[K][2];
       	for (int i = 0; i < K; i++) {
       		result[i] = pq.poll();
       	}

       	return result;
    }
}
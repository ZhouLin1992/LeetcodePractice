class Solution {
    public int[][] kClosest(int[][] points, int K) {
    	if (points == null || points.length == 0 || points[0].length == 0) {
    		return new int[0][0];
    	}

    	Comparator<int[]> comp = new Comparator<int[]>() {
    		@Override
    		public int compare(int[] arr1, int[] arr2) {
    			return (arr1[0] * arr1[0] + arr1[1] * arr1[1]) - (arr2[0] * arr2[0] + arr2[1] * arr2[1]);
    		}
    	};

    	Arrays.sort(points, comp);
    	return Arrays.copyOfRange(points, 0, K);
    }
}
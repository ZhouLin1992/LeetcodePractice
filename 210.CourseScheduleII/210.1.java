class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
        	edges[i] = new ArrayList<Integer>();
        }

        for (int[] array : prerequisites) {
        	degrees[array[0]]++;
        	edges[array[1]].add(array[0]);
        }

        for (int i = 0; i < numCourses; i++) {
        	if (degrees[i] == 0) {
        		queue.offer(i);
        	}
        }

        int[] result = new int[numCourses];
        int i = 0;
        int count = 0;
        while (!queue.isEmpty()) {
        	int node = (int)queue.poll();
        	count++;
        	result[i++] = node;
        	for (int idx = 0; idx < edges[node].size(); idx++) {
        		int edge = (int)edges[node].get(idx);
        		degrees[edge]--;
        		if (degrees[edge] == 0) {
        			queue.offer(edge);
        		}
        	}
        }

        if (count == numCourses) {
        	return result;
        }

        return new int[0];
    }
}
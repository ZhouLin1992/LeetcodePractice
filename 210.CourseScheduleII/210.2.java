/*
0: not visited
1: visting
2: visited
 */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] edges = new ArrayList[numCourses];
		int[] visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			edges[i] = new ArrayList<Integer>();
		}

		for (int[] array : prerequisites) {
			edges[array[1]].add(array[0]);
		}

		Deque<Integer> stack = new LinkedList<>();
		for (int course = 0; course < numCourses; course++) {
			if (visited[course] == 2) {
				continue;
			}
			if (!dfs(edges, visited, stack, course)) {
				return new int[0];
			}
		}

		int[] result = new int[numCourses];
		for (int i = 0; !stack.isEmpty(); i++) {
			result[i] = stack.pop();
		}

		return result;
    }

    private boolean dfs(List<Integer>[] edges, int[] visited, Deque<Integer> stack, int course) {
    	// 1: the course has already been visited, there is a cycle
    	if (visited[course] == 1) {
    		return false;
    	} else if (visited[course] == 2) {
    		return true;
    	}

    	visited[course] = 1;
    	for (int i = 0; i < edges[course].size(); i++) {
    		int edge = edges[course].get(i);
    		if (!dfs(edges, visited, stack, edge)) {
    			return false;
    		}
    	}

    	stack.push(course);
    	visited[course] = 2;
    	return true;
    }
}
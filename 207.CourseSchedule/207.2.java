// DFS

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] completed = new boolean[numCourses];
        List[] edges = new List[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] array : prerequisites) {
            edges[array[1]].add(array[0]);
        }
        
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(visited, completed, edges, course)) {
                return false;
            }
        }
        
        return true;
    }
    
    // whether a course can be completed or not
    private boolean dfs(boolean[] visited, boolean[] completed, List[] edges, int course) {
        if (visited[course]) {
            return completed[course];
        }
        visited[course] = true;
        
        for (int i = 0; i < edges[course].size(); i++) {
            if (!dfs(visited, completed, edges, (int)edges[course].get(i))) {
                completed[course] = false;
                return false;
            }
        }
        
        completed[course] = true;
        return true;
    }
}
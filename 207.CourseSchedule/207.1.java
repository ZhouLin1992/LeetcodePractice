// topological sort

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        
        // dont forget to initialize a new ArrayList
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int[] pre: prerequisites) {
            degrees[pre[0]]++;
            edges[pre[1]].add(pre[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // find those node whose in-degree is 0
            if (degrees[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            int course = (int)queue.poll();
            count++;
            for (int i = 0; i < edges[course].size(); i++) {
                int pointer = (int)edges[course].get(i);
                degrees[pointer]--;
                if (degrees[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }
        
        return count == numCourses;
    }
}
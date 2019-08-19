class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
            return new LinkedList<>();
        }
        
        Set<String> set = new HashSet<>(wordList);
        
        set.add(beginWord);
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        for (String str : set) {
            map.put(str, new LinkedList<>());
        }
        distance.put(endWord, 0);
        
        bfs(map, distance, beginWord, endWord, set);
        
        List<List<String>> paths = new LinkedList<>();
        
        dfs(map, distance, beginWord, endWord, paths, new LinkedList<String>());
        
        return paths;
    }
    
    // end -> start
    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String beginWord, String endWord, Set<String> set) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(endWord);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            List<String> neis = getNeighbors(curr, set);
            
            for (String nei : neis) {
                map.get(nei).add(curr);
                if (!distance.containsKey(nei)) {
                    distance.put(nei, distance.get(curr) + 1);
                    queue.offer(nei);
                }
            }
        }   
    }

    private List<String> getNeighbors(String curr, Set<String> set) {
        List<String> result = new LinkedList<>();
        char[] currChars = curr.toCharArray();
        for (int i = 0; i < currChars.length; i++) {
            char old = currChars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                currChars[i] = j;
                
                String newCurr = new String(currChars);
                
                if (!curr.equals(newCurr) && set.contains(newCurr)) {
                    result.add(newCurr);
                }
            }
            currChars[i] = old;
        }
        return result;
    }

    // start -> end
    private void dfs(Map<String, List<String>> map, Map<String, Integer> distance, String curr, String end, List<List<String>> paths, List<String> path) {
        path.add(curr);
        if (curr.equals(end)) {
            paths.add(new LinkedList<>(path));
        } else {
            for (String nei : map.get(curr)) {
                if (distance.get(curr) == distance.get(nei) + 1) {
                    dfs(map, distance, nei, end, paths, path);
                }
            }
        }
        path.remove(path.size() - 1);
    }
}
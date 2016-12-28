public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited = new HashSet<>();
        Set<String> replicate = new HashSet<>();
        
        for (int i = 0; i + 9 < s.length(); i++) {
            String newString = s.substring(i, i + 10);
            if (!visited.add(newString)) {
                replicate.add(newString);
            }
        }
        return new ArrayList<String>(replicate);
    }
}
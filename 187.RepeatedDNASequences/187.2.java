// traverse the input string: O(N)
// hashtable: O(1)
// total: O(1)

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        List<String> res = new ArrayList<>();
        int[] mapping = new int[26];
        
        // hash function: only 4 letters, can be
        // represented by 2 bits
        mapping['A' - 'A'] = 0;
        mapping['C' - 'A'] = 1;
        mapping['G' - 'A'] = 2;
        mapping['T' - 'A'] = 3;
   
        for (int i = 0; i + 9 < s.length(); i++) {
            int sequence = 0;
            for (int j = i; j <= i + 9; j++) {
                // shift existing sequence by two to make space
                sequence <<= 2;
                // adding new charaters
                sequence |= mapping[s.charAt(j) - 'A'];
            }
            
            // corner case: "AAAAA AAAAA AA"
            // avoid adding too many duplicates
            if (!visited.add(sequence) && duplicate.add(sequence)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
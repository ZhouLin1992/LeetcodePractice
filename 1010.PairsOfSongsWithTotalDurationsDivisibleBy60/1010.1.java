/**
Calculate the time % 60 then it will be exactly same as two sum problem.

t % 60 gets the remainder from 0 to 59.
We count the occurrence of each remainders in a array/hashmap c.

we want to know that, for each t,
how many x satisfy (t + x) % 60 = 0.
**/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) {
            return 0;
        }
        
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : time) {
            i = i % 60;
            int diff = 60 - i == 60 ? 0 : 60 - i;
            result += map.getOrDefault(diff, 0);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        return result;
    }
}
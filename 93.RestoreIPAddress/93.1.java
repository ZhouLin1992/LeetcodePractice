/*
https://leetcode.com/problems/restore-ip-addresses/discuss/30944/Very-simple-DFS-solution

If one already put a dot that leaves only 3 possibilities for the next dot to be placed: after one digit, after two digits, 
or after three digits. The first dot has only 3 available slots as well.
That propagates constraints and helps to reduce a number of combinations to consider. It's enough to check just 3×3×3=27.

time: o(27)
*/



class Solution {
    public List<String> restoreIpAddresses(String s) {
		List<String> solutions = new LinkedList<>();
		restoreIpAddresses(s, 0, "", solutions, 0);
		return solutions;
    }

    private void restoreIpAddresses(String s, int index, String restoredStr, List<String> solutions, int count) {
        if (count > 4) {
            return;
        }
        
    	if (count == 4 && index == s.length()) {
    		solutions.add(restoredStr);
            return;
    	}

    	for (int i = 1; i < 4; i++) {
    		if (index + i > s.length()) {
    			break;
    		}
    		String part = s.substring(index, index + i);
    		if ((part.startsWith("0") && part.length() > 1) || (i == 3 && Integer.valueOf(part) >= 256)) {
    			break;
    		}
    		String nextPart = restoredStr + part + (count == 3 ? "" : ".");
    		restoreIpAddresses(s, index + i, nextPart, solutions, count + 1);
    	}
    }
}
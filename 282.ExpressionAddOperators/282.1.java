/*
edge cases to be considered:
1. overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
2. 0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
3. a little trick is that we should save the value that is to be multiplied in the next recursion.
*/

class Solution {
    public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();

		if (num == null || num.length() == 0) {
			return result;
		}

		dfs(result, target, num, "", 0, 0, 0);

		return result;
    }

    private void dfs(List<String> result, int target, String num, String path, int pos, long sum, long prev) {
    	if (pos == num.length()) {
    		if (sum == target) {
    			result.add(path);
    		}
    		return;
    	}

    	for (int i = pos; i < num.length(); i++) {
    		// any number with 2 or more digits cannot have leading zero(s).
    		if (i != pos && num.charAt(pos) == '0') {
    			break;
    		}

    		long curr = Long.parseLong(num.substring(pos, i + 1));

    		if (pos == 0) {
    			dfs(result, target, num, path + curr, i + 1, curr, curr);
    		} else {
    			dfs(result, target, num, path + "+" + curr, i + 1, sum + curr, curr);
    			dfs(result, target, num, path + "-" + curr, i + 1, sum - curr, -curr);
    			dfs(result, target, num, path + "*" + curr, i + 1, sum - prev + prev * curr, prev * curr);
    		}
    	}
    }
}
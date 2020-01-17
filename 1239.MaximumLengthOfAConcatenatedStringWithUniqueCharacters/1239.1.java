class Solution {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        
        List<String> result = new ArrayList<>();
        result.add("");
        for (String str : arr) {
            if (!isUnique(str)) {
                continue;
            }
            List<String> temp = new ArrayList<>();
            for (String s : result) {
                s = s + str;
                if (isUnique(s)) {
                    temp.add(s);
                }
            }
            result.addAll(temp);
        }
        
        int max = 0;
        for (String str : result) {
            max = Math.max(max, str.length());
        }
        return max;
    }
    
    private boolean isUnique(String str) {
        if (str.length() > 26) {
            return false;
        }
        boolean[] doesExist = new boolean[26];
        for (char ch : str.toCharArray()) {
            if (doesExist[ch - 'a']) {
                return false;
            }
            doesExist[ch - 'a'] = true;
        }
        return true;
    }
}
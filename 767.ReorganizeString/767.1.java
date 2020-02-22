class Solution {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        for (char ch : S.toCharArray()) {
            counts[ch - 'a']++;
        }
        
        // 找到出现次数最多的字符
        int maxIndex = 0;
        int maxCount = counts[0];
        for (int i = 1; i < 26; i++) {
            if (counts[i] > maxCount) {
                maxIndex = i;
                maxCount = counts[i];
            }
        }
        
        // 如果字符数最多的字符比（长度+1）/2还要多 结果必然会有相隔字符相同 直接返回
        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }
        
        char[] result = new char[S.length()];
        char maxChar = (char)(maxIndex + 'a');
        int index = 0;
        while (counts[maxIndex] != 0) {
            result[index] = maxChar;
            index += 2;
            counts[maxIndex]--;
        }

        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0) {
                if (index >= S.length()) {
                    index = 1;
                }
                result[index] = (char)(i + 'a');
                counts[i]--;
                index += 2;
            }
        }
        
        return new String(result);
    }
}
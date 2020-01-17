class Solution {
    public int compress(char[] chars) {
        int indexAns = 0;
        int index = 0;
        while (index < chars.length) {
            char ch = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == ch) {
                index++;
                count++;
            }
            
            chars[indexAns++] = ch;
            if (count != 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[indexAns++] = c;
                }
            }
        }
        return indexAns;
    }
}
class Solution {
    public void reverseWords(char[] str) {
        int len = str.length;
        // reverse the whole string
        reverse(str, 0, len - 1);
        
        int start = 0;
        int end = 0;
        // reverse every single word
        while (end < len) {
            start = end;
            while (end < len && str[end] != ' ') {
                end++;
            }
            reverse(str, start, end - 1);
            end++;
        }
    }
    
    private void reverse(char[] str, int start, int end) {
        char temp;
        while (start < end) {
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
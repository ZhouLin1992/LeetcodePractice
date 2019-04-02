class Solution {
    public void reverseWords(char[] str) {
        int len = str.length;
        // reverse the whole sentence
        reverse(str, 0, len - 1);
        int start = 0;
        // reverse each word
        for (int i = 0; i < len; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        // reverse the last word, if there is only one word, this will solve the corner case
        reverse(str, start, len - 1);
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
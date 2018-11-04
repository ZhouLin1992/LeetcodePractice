class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int begin = 0;
        int mark;
        long result = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                begin = i;
                break;
            }
        }
        
        if (str.charAt(begin) == '-') {
            mark = -1;
            begin++;
        } else if (str.charAt(begin) == '+') {
            mark = 1;
            begin++;
        } else if ('0' <= str.charAt(begin) && str.charAt(begin) <= '9') {
            mark = 1;
        } else {
            return 0;
        }
        
        for (; begin < str.length(); begin++) {
            char ch = str.charAt(begin);
            if ('0' <= str.charAt(begin) && str.charAt(begin) <= '9') {
                result = result * 10 + (ch - '0');
                if (mark * result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (mark * result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        
        return (int) (mark * result);
    }
}
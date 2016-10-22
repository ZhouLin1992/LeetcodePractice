public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] res = new int[len1 + len2];
        
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int p1 = i + j, p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[p2];
                
                res[p1] += sum / 10;
                res[p2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num: res)
            if (!(sb.length() == 0 && num == 0)) sb.append(num);
        	// OR
        	// if (sb.length() > 0 || num > 0) sb.append(num);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
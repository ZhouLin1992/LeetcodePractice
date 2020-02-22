class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i1 = num1.length() - 1, i2 = num2.length() - 1; carry == 1 || i1 >= 0 || i2 >= 0; i1--, i2--) {
            int digit1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int digit2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        
        return sb.reverse().toString();
    }
}
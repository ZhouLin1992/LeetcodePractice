public class Solution {
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        String res = "";
        int i = 0;
        int carry = 0;
        while (i < lena || i < lenb || carry != 0) {
            int inta = lena - 1 - i >= 0 ? Character.getNumericValue(a.charAt(lena - 1 - i)) : 0;
            int intb = lenb - 1 - i >= 0 ? Character.getNumericValue(b.charAt(lenb - 1 - i)) : 0;
            int sum = inta + intb + carry;
            res = sum % 2 + res;
            carry = sum / 2;
            ++i;
        }
        return res;
    }
}
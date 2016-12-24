public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        // longer
        int pa = a.length() - 1;
        // shorter
        int pb = b.length() - 1;
        String res = "";
        int carry = 0;
        
        while (pb >= 0) {
            int intb = b.charAt(pb) - '0';
            int inta = a.charAt(pa) - '0';
            int sum = inta + intb + carry;
            res = String.valueOf(sum % 2) + res;
            carry = sum / 2;
            pb--;
            pa--;
        }
        
        while (pa >= 0) {
            int inta = a.charAt(pa) - '0';
            int sum = inta + carry;
            res = String.valueOf(sum % 2) + res;
            carry = sum / 2;
            pa--;
        }
        
        if (carry == 1) {
            res = "1" + res;
        }
        
        return res;
    }
}
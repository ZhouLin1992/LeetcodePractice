public class Solution {
    public String intToRoman(int num) {
		if (num < 1 || num > 3999) return "";

		String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] m = {"", "M", "MM", "MMM"};

		return (m[num / 1000] + c[num % 1000 / 100] + x[num % 100 / 10] + i[num % 10]);      
    }
}
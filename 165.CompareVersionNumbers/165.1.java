public class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0, len1 = version1.length(), len2 = version2.length();
            
        while (i < len1 || j < len2) {
            int sum1 = 0, sum2 = 0;
            while (i < len1 && version1.charAt(i) != '.') sum1 = sum1 * 10 + version1.charAt(i++) - '0';
            while (j < len2 && version2.charAt(j) != '.') sum2 = sum2 * 10 + version2.charAt(j++) - '0';
            if (sum1 > sum2) return 1;
            if (sum1 < sum2) return -1;
            i++;
            j++;
        }
        return 0;
    }
}
public class Solution {
    public String largestNumber(int[] nums) {
        // new String array
        String[] strs = new String[nums.length];
        int i = 0;
        for (int num: nums) {
            strs[i++] = String.valueOf(num);
        }
        
        // sort, self defined comparator
        // sort in descending order
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String tmp1 = str1 + str2;
                String tmp2 = str2 + str1;
                return tmp2.compareTo(tmp1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str);
        }
        
        /* corner case:
        Input:     [0,0]
        Output:    "00"
        Expected:  "0"  */
        
        if (sb.charAt(0) == '0') {
            return String.valueOf("0");
        }
        
        return sb.toString();
    }
}
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        int pow = 1;
        for (int i = 1, tmp = 0; i <= num; i++, tmp++) {
            if (i == pow) {
                pow *= 2;
                tmp = 0;
            }
            res[i] = res[tmp] + 1;
        }
    }

}
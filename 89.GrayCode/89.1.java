public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            list.add(0);
            return list;
        }
        
        list = grayCode(n - 1);
        
        // << 运算优先级比 + 要低
        for (int i = list.size() - 1; i >= 0; i--) {
            int add = (1 << (n - 1)) + list.get(i);
            list.add(add);
        }
        return list;
    }
}
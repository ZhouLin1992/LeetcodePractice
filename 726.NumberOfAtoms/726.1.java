class Solution {
    private int i;
    
    public String countOfAtoms(String formula) {
        if (formula == null || formula.length() == 0) {
            return formula;
        }
        
        char[] f = formula.toCharArray();
        Map<String, Integer> map = countOfAtoms(f);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
            int count = entry.getValue();
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }
    
    private Map<String, Integer> countOfAtoms(char[] f) {
        Map<String, Integer> map = new TreeMap<>();
        while (i < f.length) {
            if (f[i] == '(') {
                i++;
                Map<String, Integer> tmp = countOfAtoms(f);
                int count = getCount(f);
                for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }
            } else if (f[i] == ')') {
                i++;
                return map;
            } else {
                String name = getName(f);
                int count = getCount(f);
                map.put(name, map.getOrDefault(name, 0) + count);
            }
        }
        return map;
    }
    
    private String getName(char[] f) {
        String name = f[i++] + "";
        while (i < f.length && 'a' <= f[i] && f[i] <= 'z') {
            name += f[i++];
        }
        return name;
    }
    
    private int getCount(char[] f) {
        int count = 0;
        while (i < f.length && '0' <= f[i] && f[i] <= '9') {
            count = count * 10 + (f[i] - '0');
            i++;
        }
        return count == 0 ? 1 : count;
    }
}
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return result;
        }
        
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String lStr = input.substring(0, i);
                String rStr = input.substring(i + 1);
                List<Integer> left = map.getOrDefault(lStr, diffWaysToCompute(lStr));
                List<Integer> right = map.getOrDefault(rStr, diffWaysToCompute(rStr));

                for (Integer l : left) {
                    for (Integer r : right) {
                        switch(ch) {
                            case '+': result.add(l + r); break;
                            case '-': result.add(l - r); break;
                            case '*': result.add(l * r); break;
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.parseInt(input));            
        }

        return result;
    }
}
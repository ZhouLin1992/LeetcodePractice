class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) {
            return new LinkedList<>();
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                continue;
            }
            
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String str = queue.poll();
                char[] chs = str.toCharArray();
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(new String(chs));
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(new String(chs));
            }
        }
        
        return new LinkedList<>(queue);
    }
}
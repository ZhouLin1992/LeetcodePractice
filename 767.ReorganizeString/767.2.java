class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : S.toCharArray()) {
            int count = map.getOrDefault(ch, 0) + 1;
            if (count > (S.length() + 1) / 2) {
                return "";
            }
            map.put(ch, count);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char)first[0]);
                if (--first[1] > 0) {
                    pq.offer(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char)second[0]);
                if (--second[1] > 0) {
                    pq.offer(second);
                }
                // 记住要重新加入first
                pq.offer(first);
            }
        }
        
        return sb.toString();
    }
}
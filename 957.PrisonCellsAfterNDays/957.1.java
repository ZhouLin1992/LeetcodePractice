class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) {
            return cells;
        }

        int len = cells.length;
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            seen.put(Arrays.toString(cells), N--);
            int[] nextCell = new int[len];
            for (int i = 1; i < len - 1; i++) {
                nextCell[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = nextCell;
            if (seen.containsKey(Arrays.toString(cells))) {
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
        
        return cells;
    }
}
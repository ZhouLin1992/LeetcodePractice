class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N <= 0) {
            return cells;
        }

        Set<String> seen = new HashSet<>();
        boolean hasCycle = false;
        int cycle = 0;

        for (int i = 0; i < N; i++) {
            int[] newCell = nextCell(cells);

            String key = Arrays.toString(newCell);
            if (!seen.contains(key)) {
                seen.add(key);
                cycle++;
            } else {
                hasCycle = true;
                break;
            }
            
            cells = newCell;
        }
        
        if (hasCycle) {
            N %= cycle;
            for (int i = 0; i < N; i++) {
                cells = nextCell(cells);
            }
        }

        return cells;
    }
    
    private int[] nextCell(int[] cells) {
        int[] newCell = new int[cells.length];
        for (int i = 1; i < 7; i++) {
            newCell[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return newCell;
    }
}
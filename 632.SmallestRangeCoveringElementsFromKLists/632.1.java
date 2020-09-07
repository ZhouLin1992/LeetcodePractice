class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<Item> queue = new PriorityQueue<>(new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                return i1.val - i2.val;
            }
        });

        int max = Integer.MIN_VALUE;
        
        // 初始化
        for (int r = 0; r < nums.size(); r++) {
            int curr = nums.get(r).get(0);
            queue.offer(new Item(r, 0, curr));
            max = Math.max(max, curr);
        }
        
        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;
        int range = Integer.MAX_VALUE;
        
        while (queue.size() == nums.size()) {
            Item curr = queue.poll();
            if (max - curr.val < range) {
                start = curr.val;
                end = max;
                range = max - curr.val;
            }
            if (curr.col + 1 < nums.get(curr.row).size()) {
                curr.col += 1;
                curr.val = nums.get(curr.row).get(curr.col);
                queue.offer(curr);
                max = Math.max(curr.val, max);
            }
        }
        
        return new int[]{start, end};
    }
}

class Item {
    int row;
    int col;
    int val;

    public Item(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
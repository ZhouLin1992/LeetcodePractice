/**
* Find the critical point that change the max height
*/

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }

        // store building heights
        ArrayList<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            // start of a building, height stored as negative
            heights.add(new int[]{b[0], -b[2]});
            // end of a building, height stored as positive
            heights.add(new int[]{b[1], b[2]});
        }

        /**
        * 1. if coordinate is not the same, sort the coordinate
        * 2. if coordinate is the same, consider the following:
        *    a) if both of them are start coordinates, consider the larger height (that's why left coordinates are marked as negative)
        *    b) if both of them are end coordinates, consider let the smaller height go out first
        *    c) if one is start coordinate, and one is end coordinate, consider the start coordinate first
        */    
        Collections.sort(heights, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });
        
        int prev = 0;
        // store all encouterd building height in descending order
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(0);
        
        for (int[] h : heights) {
            if (h[1] < 0) {
                // meet a new buildling and add it to queue
                queue.offer(-h[1]);
            } else {
                // reach the end of the building, remove it from queue
                queue.remove(h[1]);
            }
            // current max height in all encountered buildings
            int peek = queue.peek();
            // if the current max height is different from the previous one, which means a critical point
            // has met, add it to the result list
            if (peek != prev) {
                result.add(new ArrayList<Integer>(Arrays.asList(new Integer[]{h[0], peek})));
                prev = peek;
            }
        }

        return result;
    }
}
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        
        Arrays.sort(people, new Comparator<>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? p2[0] - p1[0] : p1[1] - p2[1];
            }
        });
        
        List<int[]> list = new ArrayList<>();
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }
        
        return list.toArray(new int[people.length][]);
    }
}
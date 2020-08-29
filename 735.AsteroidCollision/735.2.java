class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return asteroids;
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        for (int a : asteroids) {
            if (a > 0) {
                list.add(a);
            } else {
                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() < -a) {
                    list.pollLast();
                }
                
                if (!list.isEmpty() && list.getLast() == -a) {
                    list.pollLast();
                } else if (list.isEmpty() || list.getLast() < 0) {
                    list.add(a);
                }
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
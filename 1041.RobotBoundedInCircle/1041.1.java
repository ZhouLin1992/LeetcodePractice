/**
One, if you end up where you started, it is a circle. 
Two, if you end up in a different place with facing north (again), hence you are drifting away. 
All other scenarios are going to be in a circle (or come back) in infinity no matter. You can think that the starting and the end point form a vector. Unless the end direction is north, concataned vectors will always end up on the starting point eventually (infinity).
**/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int dir = 0; // 0:上(north)/1:右/2:下/3:左
        int[] point = {0, 0};
        
        for (char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                point[0] += dirs[dir][0];
                point[1] += dirs[dir][1];
            } else if (ch == 'L') {
                dir = (dir + 3) % 4;
            } else {
                dir = (dir + 1) % 4;
            }
        }
        
        // ended up at the same place
        if (point[0] == 0 && point[1] == 0) {
            return true;
        }
        
        // if the direction is north and location has changed
        if (dir == 0 && !(point[0] == 0 && point[1] == 0)) {
            return false;
        }
        
        return true;
    }
}
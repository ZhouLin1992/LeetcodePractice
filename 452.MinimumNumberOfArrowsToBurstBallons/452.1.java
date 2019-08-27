/*
将res初始化为1，因为气球数量不为0，所以怎么也得先来一发啊，然后这一箭能覆盖的最远位置就是第一个气球的结束点，
用变量end来表示。然后我们开始遍历剩下的气球，如果当前气球的开始点小于等于end，说明跟之前的气球有重合，之前那一箭也
可以照顾到当前的气球，此时我们要更新end的位置，end更新为两个气球结束点之间较小的那个，这也是当前气球和之前气球的重合
点，然后继续看后面的气球；如果某个气球的起始点大于end了，说明前面的箭无法覆盖到当前的气球，那么就得再来一发，既然又来
了一发，那么我们此时就要把end设为当前气球的结束点了，这样贪婪算法遍历结束后就能得到最少的箭数了
*/

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        
        List<Interval> list = new LinkedList<>();
        for (int[] point : points) {
            list.add(new Interval(point[0], point[1]));
        }
        Collections.sort(list, (i1, i2) -> (i1.start - i2.start));
        
        int shoot = 1;
        int end = list.get(0).end;
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start <= end) {
                end = Math.min(end, list.get(i).end);
            } else {
                end = list.get(i).end;
                shoot++;
            }
        }
        
        return shoot;
    }
}

class Interval {
    int start;
    int end;
    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}
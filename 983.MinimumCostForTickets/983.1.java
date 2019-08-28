class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0 || costs == null || costs.length == 0) {
            return 0;
        }
        
        int lastDay = days[days.length - 1];
        int[] expense = new int[lastDay + 1];
        Arrays.fill(expense, -1);
        
        expense[0] = 0;
        for (int day : days) {
            expense[day] = 0;
        }
        
        for (int i = 1; i <= lastDay; i++) {
            if (expense[i] == -1) {
                expense[i] = expense[i - 1];
                continue;
            }
            
            expense[i] = costs[0] + expense[i - 1];
            expense[i] = Math.min(costs[1] + expense[Math.max(i - 7, 0)], expense[i]);
            expense[i] = Math.min(costs[2] + expense[Math.max(i - 30, 0)], expense[i]);
        }
        
        return expense[lastDay];
    }
}
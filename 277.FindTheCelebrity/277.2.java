/*
针对该问题的一个特殊trick。核心的一点是，调用一次knows(a,b)就能至少剔除一个候选人：
1. 如果返回true，也即a认识b，那么一定可以判断a不可能是celebrity；
2. 如果返回false，也即a不认识b，那么一定可以判断b不可能是celebrity.
于是，我们可以得到一个结论：调用n-1次knows()，就能剔除n-1个候选人，剩下的那一个，可能是celebrity，也可能不是，须要进一步判断。
*/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // pick up the candidate
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            /*
            if candidate knows i, this candidate surely is not a celebrity, switch candidate to i temporarily
            if candidate doesn't know i, i surely is not a celebrity
            */
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        /*
        第一个循环结束后，可以确认的有两件事：
        1）candidate之后的所有人， candidate都不认识；
        2）candidate之前的人，都一定不是名人（因为有人不认识这些人）；
        如果有一个名人，那么这个人一定至少满足以上2个条件，当然candidate也可能不是名人，但是也满足这个条件.这就需要第二个loop来验证
        */
        
        /*
        第二个loop需要继续验证两件事情，1）candidate 不认识所有人， 2）所有人都认识candidate
        */
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }
        
        return candidate;
    }
}
/*
Simulate the process with a queue.

1. Sort the deck, it is actually the "final sequence" we want to get according to the question.
2. Then put it back to the result array, we just need to deal with the index now!
3. Simulate the process with a queue (initialized with 0,1,2...(n-1)), now how do we pick the card?
4. We first pick the index at the top: res[q.poll()]=deck[i]
5. Then we put the next index to the bottom: q.add(q.poll());
6. Repeat it n times, and you will have the result array!
*/

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null || deck.length == 0) {
            return deck;
        }
        
        int len = deck.length;
        int[] result = new int[len];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.sort(deck);

        for (int i = 0; i < len; i++) {
            queue.offer(i);
        }

        for (int i = 0; i < len; i++) {
            result[queue.poll()] = deck[i];
            queue.offer(queue.poll());
        }
        
        return result;
    }
}
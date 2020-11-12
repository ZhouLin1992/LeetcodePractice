/**
For any one Arrays.binarySearch() returns the index of the element if it's in the array or ( -(insertion point) - 1). 
Insertion point is the point where the key (i.e idx) would be inserted in the array 
and it's either the index of the first element greater than the key or the array length if the key is greater than all the array elements.

For example using the array [1,3,6] and idx of 4. Arrays.binarySearch() will return (-(2)-1) = -3
2 is the index of 6 which is the first element greater than 4. So to return the index we need (i.e index of 6) we did -(-3) -1 = 2
**/

class Solution {
    int[] probability;
    int sum;
    Random random;
    
    public Solution(int[] w) {
        probability = new int[w.length];
        probability[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            probability[i] = probability[i - 1] + w[i];
        }
        sum = probability[w.length - 1];
        random = new Random();
    }
    
    public int pickIndex() {
        int target = random.nextInt(sum) + 1;
        int idx = Arrays.binarySearch(probability, target);
        if (idx < 0) {
            return -(idx + 1);
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
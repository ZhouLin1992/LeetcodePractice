/*
We need to form the pairings of the array's elements such that the overall sum of the minimum out of such pairings is maximum. 
Thus, we can look at the operation of choosing the minimum out of the pairing, say (a,b) as incurring a loss of a - b(if a>b), 
in the maximum sum possible. The total sum will now be maximum if the overall loss incurred from such pairings is minimized. 
This minimization of loss in every pairing is possible only if the numbers chosen for the pairings lie closer to each other than 
to the other elements of the array.
*/

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
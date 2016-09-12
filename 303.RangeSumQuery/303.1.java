public class NumArray {
    private ArrayList<Integer> newArray = new ArrayList<>();

    public NumArray(int[] nums) {
        int total = 0;
        newArray.add(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            total += nums[i - 1];
            newArray.add(i, total);
        }
    }

    public int sumRange(int i, int j) {
        return newArray.get(j + 1) - newArray.get(i);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
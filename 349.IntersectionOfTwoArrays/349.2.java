public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0)
	        return new int[0];

		int[] temp = new int[nums1.length < nums2.length ? nums1.length : nums2.length];	        
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, j = 0, count = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				i++;
			else if (nums1[i] > nums2[j])
				j++;
			else {
   				if (count == 0 || temp[count - 1] != nums1[i]) 
   					temp[count++] = nums1[i];
       			i++;
       			j++;

			}
		}

		int[] res = new int[count];
		for (int k = 0; k < count; k++) 
			res[k] = temp[k];

		return res;
    }
}
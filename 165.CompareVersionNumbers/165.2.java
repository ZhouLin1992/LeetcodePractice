public class Solution {
    public int compareVersion(String version1, String version2) {
		String[] str1 = version1.split("\\.");
		String[] str2 = version2.split("\\.");

		int len = Math.max(str1.length, str2.length);
		for (int i = 0; i < len; i++) {
			Integer num1 = i < str1.length ? Integer.parseInt(str1[i]) : 0;
			Integer num2 = i < str2.length ? Integer.parseInt(str2[i]) : 0;
			int compare = num1.compareTo(num2);
			if (compare != 0) return compare;
		}
		return 0;
    }
}
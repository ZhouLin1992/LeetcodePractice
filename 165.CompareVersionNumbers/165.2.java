class Solution {
	public int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int len1 = v1.length;
		int len2 = v2.length;
		int len = Math.max(len1, len2);
		for (int i = 0; i < len; i++) {
			Integer num1 = i < len1 ? Integer.parseInt(v1[i]) : 0;
			Integer num2 = i < len2 ? Integer.parseInt(v2[i]) : 0;

			int compare = num1.compareTo(num2);
			if (compare != 0) {
				return compare;
			}
		}

		return 0;
	}
}
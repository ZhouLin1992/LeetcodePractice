public class Solution {
	public List<String> fizzBuzz(int n) {
		if (n < 1) {
			return new ArrayList<String>();
		}

		List<String> list = new ArrayList<>();
		for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
			fizz++;
			buzz++;
			if (fizz == 3 && buzz == 5) {
				fizz = 0;
				buzz = 0;
				list.add("FizzBuzz");
			} else if (fizz == 3) {
				fizz = 0;
				list.add("Fizz");
			} else if (buzz == 5) {
				buzz = 0;
				list.add("Buzz");
			} else {
				list.add(String.valueOf(i));
			}
		}
		return list;
	}
}
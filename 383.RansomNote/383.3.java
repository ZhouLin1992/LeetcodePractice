public class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() == 0 && magazine.length() == 0) return true;
		if (ransomNote.length() != 0 && magazine.length() == 0) return false;

		char[] r = ransomNote.toCharArray();
		char[] m = magazine.toCharArray();
		ArrayList<Character> al = new ArrayList<>();

		for (char ch: m) 
			al.add(m);

		for (char ch: r)
			if(!al.remove(r))
				return false;

		return true;

	}
}
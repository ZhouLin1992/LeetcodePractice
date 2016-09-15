public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() == 0 && magazine.length() == 0) return true;
	    if (ransomNote.length() != 0 && magazine.length() == 0) return false;
		
		HashMap<Character, Integer> hm = new HashMap<>();

		char[] r = ransomNote.toCharArray();
		char[] m = magazine.toCharArray();

		for (char s: m)
			if (hm.containsKey(s))
				hm.put(s, hm.get(s) + 1);
			else 
				hm.put(s, 1);

		for (char s: r)
			if (!hm.containsKey(s))
				return false;
			else 
				if (hm.get(s) != 0)
					hm.put(s, hm.get(s) - 1);
				else 
					return false;

		return true;
    }
}
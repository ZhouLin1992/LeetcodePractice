public class TwoSum {
    HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
    ArrayList<Integer> arrlst = new ArrayList<Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (hm.containsKey(number))
	        hm.put(number, true);
	    else {
            arrlst.add(number);
            hm.put(number, false);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
        for(Integer ref: arrlst) {
            int diff = value - ref;
            if (diff != ref && hm.containsKey(diff) || diff == ref && hm.get(ref))
                return true;
        }
        return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
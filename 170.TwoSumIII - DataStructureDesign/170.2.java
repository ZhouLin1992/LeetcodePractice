public class TwoSum {
    HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (hm.containsKey(number))
	        hm.put(number, true);
	    else 
            hm.put(number, false);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
        for (Map.Entry<Integer, Boolean> entry: hm.entrySet()) {    
            int first = entry.getKey();
            int second = value - first;
            if (first != second && hm.containsKey(second) || first == second && entry.getValue())
                return true;
        }
        return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
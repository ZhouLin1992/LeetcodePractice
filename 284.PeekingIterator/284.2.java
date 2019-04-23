// https://leetcode.com/problems/peeking-iterator/discuss/72558/Concise-Java-Solution

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> iter;
    private boolean done;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        advanceIterator(iter);
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = next;
        advanceIterator(iter);
        return result;
    }

    private void advanceIterator(Iterator<Integer> iter) {
        if (iter.hasNext()) {
            next = iter.next();
        } else {
            done = true;
        }
    }

    @Override
    public boolean hasNext() {
        return !done;
    }
}
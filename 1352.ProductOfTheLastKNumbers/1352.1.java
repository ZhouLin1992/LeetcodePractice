class ProductOfNumbers {
    private List<Integer> list;
    
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if (num > 0) {
            list.add(list.get(list.size() - 1) * num);
        } else {
            list = new ArrayList<>();
            list.add(1);
        }
    }
    
    public int getProduct(int k) {
        int len = list.size();
        return k < len ? list.get(len - 1) / list.get(len - 1 - k) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
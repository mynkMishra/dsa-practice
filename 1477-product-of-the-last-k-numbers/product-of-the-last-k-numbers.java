class ProductOfNumbers {

    ArrayList<long[]> stream;
    public ProductOfNumbers() {
        stream = new ArrayList<long[]>();
        stream.add(new long[]{1, 1}); //num, mul
    }
    
    public void add(int num) {
        long mul = stream.get(stream.size() - 1)[1];
        
        if(num == 0){
            stream.clear();
            stream.add(new long[]{1, 1});
            return;
        }
        stream.add(new long[]{(long)num, (long)num*mul});
    }
    
    public int getProduct(int k) {

        if(k >= stream.size()){
            return 0;
        }

        long totalMul = stream.get(stream.size() - 1)[1];
        long remMul = stream.get(stream.size() - 1 - k)[1];

        return (int)(totalMul/remMul);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
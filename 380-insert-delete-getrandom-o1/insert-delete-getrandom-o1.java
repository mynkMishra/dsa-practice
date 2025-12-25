class RandomizedSet {

    Map<Integer, Integer> hm;
    ArrayList<Integer> l;
    Random random;

    public RandomizedSet() {
        hm = new HashMap<>();
        l = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(hm.get(val) == null){
            l.add(val);
            hm.put(val, l.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(hm.get(val) != null){
            int idx = hm.get(val);

            l.set(idx, l.get(l.size() - 1));
            hm.put(l.get(idx), idx);
            l.remove(l.size() - 1);
            hm.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int rIdx = random.nextInt(l.size());
        return l.get(rIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
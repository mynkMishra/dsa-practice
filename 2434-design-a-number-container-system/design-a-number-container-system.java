class NumberContainers {

    Map<Integer, Integer> indexHm;
    Map<Integer, ArrayList<Integer>> numberHm;
    public NumberContainers() {
        indexHm = new HashMap<Integer, Integer>();
        numberHm = new HashMap<Integer, ArrayList<Integer>>();
    }
    
    public void change(int index, int number) {
        if(indexHm.get(index) == null){
            indexHm.put(index, number);

            if(numberHm.get(number) == null){
                numberHm.put(number, new ArrayList<Integer>());
                numberHm.get(number).add(index);
            }else{
                ArrayList<Integer> indices = numberHm.get(number);

                int insertIndex = findIndex(indices, index);
                indices.add(insertIndex, index);
            }

        }else{
            int prevNum = indexHm.get(index);

            ArrayList<Integer> prevIndices = numberHm.get(prevNum);

            int prevIndex = findIndex(prevIndices, index);
            prevIndices.remove(prevIndex);

            indexHm.put(index, number);
            if(numberHm.get(number) == null){
                numberHm.put(number, new ArrayList<Integer>());
                numberHm.get(number).add(index);
            }else{
                ArrayList<Integer> indices = numberHm.get(number);

                int insertIndex = findIndex(indices, index);
                indices.add(insertIndex, index);
            }
        }
    }
    
    public int find(int number) {
        if(numberHm.get(number) == null || numberHm.get(number).size() == 0){
            return -1;
        }

        return numberHm.get(number).get(0);
    }

    public int findIndex(ArrayList<Integer> list, int num){
        int l = 0;
        int r = list.size() - 1;

        while(l <= r){
            int mid = l + (r - l)/2;

            if(list.get(mid) < num){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return l;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
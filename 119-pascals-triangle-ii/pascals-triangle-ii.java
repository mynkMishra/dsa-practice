class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        if(rowIndex == 0){
            return list;
        }

        list.add(1);
        if(rowIndex == 1){
            return list;
        }

        for(int i = 2; i <= rowIndex; i++){
            int size = list.size();
            for(int j = 0; j < size - 1; j++){
                list.add(list.get(0) + list.get(1));
                list.remove(0);
            }
            list.add(1);
        }

        return list;
    }
}
class Solution {
    public int[] minOperations(String boxes) {
        
        int[] boxArr = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++){
            boxArr[i] = boxes.charAt(i) == '1' ? 1 : 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();

        int rBalls = boxArr[boxArr.length - 1];
        int rSum = 0;
        for(int i = boxArr.length - 2; i>= 0; i--){
            rSum += rBalls;

            if(boxArr[i] == 1){
                rBalls++;
            }
        }

        if(boxArr[0] == 1){
            rBalls--;
        }

        int lBalls = boxArr[0];
        int lSum = 0;
        list.add(lSum + rSum);
        for(int i = 1; i < boxArr.length; i++){
            lSum += lBalls;
            rSum -= rBalls;

            list.add(lSum + rSum);

            if(boxArr[i] == 1){
                lBalls++;
                rBalls--;
            }
        }

        int[] ans = list.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}
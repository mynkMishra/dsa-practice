class Solution {
    public String rankTeams(String[] votes) {
        int[][] map = new int[26][28];

        for(int i = 0; i < 26; i++){
            map[i][26] = i;
        }

        for(String v: votes){

            for(int i = 0; i < v.length(); i++){
                char ch = v.charAt(i);
                int idx = ch - 'A';
                map[idx][i]++;
                if(map[idx][27] == 0){
                    map[idx][27] = 1;
                }
            }
        }

        Arrays.sort(map, (a, b) -> {
            for(int i = 0; i < 26; i ++){
                if(a[i] < b[i]){
                    return 1;
                }else if(a[i] > b[i]){
                    return -1;
                }
            }

            return 0;
        });


        String str = "";
        for(int i = 0; i < 26; i++){
            if(map[i][27] == 1){
                str += (char)(map[i][26] + 'A');
            }
        }

        return str;

    }
}
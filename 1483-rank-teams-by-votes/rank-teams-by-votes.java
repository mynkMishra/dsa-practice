class Solution {
    public String rankTeams(String[] votes) {
        
        int N = votes.length;
        int len = votes[0].length();
        int[][] counter = new int[26][len + 1];
        for(int i = 0; i < 26; i++) counter[i][len] = i;

        for(String vote: votes){
            for(int i = 0; i < len; i++){
                char ch = vote.charAt(i);
                int idx = (int)ch - 65;
                counter[idx][i]++;
            }
        }

        Arrays.sort(counter, (a, b) -> {
            for(int i = 0; i < len; i++){
                if(a[i] < b[i]) return 1;
                if(a[i] > b[i]) return -1;
            }

            return 0;
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            sb.append((char)('A' + counter[i][len]));
        }

        return sb.toString();
    }
}
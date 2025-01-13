class Solution {
    int[][] memo;
    public int minHeightShelves(int[][] books, int shelfWidth) {
        memo = new int[books.length][shelfWidth + 1];

        for(int[] m : memo){
            Arrays.fill(m, -1);
        }

        return solve(0, books[0][0], 0, books, shelfWidth);
    }

    public int solve(int idx, int w, int maxH, int[][] books, int sw){

        if(idx == books.length){
            return maxH;
        }
        
        if(memo[idx][w] != -1){
            return memo[idx][w];
        }

        int skip = solve(idx + 1, books[idx][0], books[idx][1], books, sw) + maxH;

        int taken = Integer.MAX_VALUE;
        if(w + books[idx][0] <= sw){
            taken = solve(idx + 1, w + books[idx][0], Math.max(books[idx][1], maxH), books, sw);
        }

        return memo[idx][w] = Math.min(skip, taken);
    }
}
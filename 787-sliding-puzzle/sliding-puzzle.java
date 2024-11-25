class Solution {
    class T {
        String state;
        int moves;

        T(String s, int m){
            state = s;
            moves = m;
        }
    }

    public int slidingPuzzle(int[][] board) {
        int[][] directions = new int[][]{
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
        };

        String target = "123450";
        StringBuilder state = new StringBuilder();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                state.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<String>();
        PriorityQueue<T> queue = new PriorityQueue<T>((T a, T b) -> a.moves - b.moves);
        queue.add(new T(state.toString(), 0));
        visited.add(state.toString());

        while(queue.size() != 0){
            T el = queue.poll();

            if(el.state.equals(target)){
                return el.moves;
            }

            int idx = el.state.indexOf("0");
            for(int dir: directions[idx]){

                String str = swap(idx, dir, el.state);

                if(visited.contains(str)){
                    continue;
                }

                StringBuilder sb = new StringBuilder(str);
                visited.add(sb.toString());
                queue.add(new T(sb.toString(), el.moves + 1));
            }
        }

        return -1;
    }

    public String swap(int i, int j, String str){
        char a = str.charAt(i);
        char b = str.charAt(j);

        char[] arr = str.toCharArray();
        arr[i] = b;
        arr[j] = a;

        return new String(arr);  
    }
}
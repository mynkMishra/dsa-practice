class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        HashSet<String> posSet = new HashSet<String>();
        HashSet<String> negSet = new HashSet<String>();

        for(String s: positive_feedback){
            posSet.add(s);
        }

        for(String s: negative_feedback){
            negSet.add(s);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        for(int i = 0 ; i < report.length; i++){
            int id = student_id[i];
            int score = 0;

            String[] words = report[i].split(" ");

            for(String w: words){
                if(posSet.contains(w)){
                    score+=3;
                }
                if(negSet.contains(w)){
                    score-=1;
                }
            }

            pq.add(new int[]{score, id});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int N = pq.size();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            list.add(-1);
        }

        int i = N - 1;
        
        while(pq.size() > 0){
            list.set(i, pq.poll()[1]);
            i--;
        }

        return list;
    }
}